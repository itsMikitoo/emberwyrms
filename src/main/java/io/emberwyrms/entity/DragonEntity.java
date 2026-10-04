package io.emberwyrms.entity;

import io.emberwyrms.ModItems;
import io.emberwyrms.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * Dragon elemental con las 5 etapas de vida de Ice and Fire (1 dia de Minecraft = 24000 ticks):
 * E1 0-24 dias (recien nacido, se lleva sobre la cabeza), E2 25-49 (usa aliento), E3 50-74 (se monta y vuela),
 * E4 75-99 (se reproduce), E5 100+ (maximo poder; tamaño maximo a los 125 dias).
 * La edad se guarda en el atributo SCALE (asi se conserva sola al guardar el mundo y se sincroniza con el cliente).
 */
public class DragonEntity extends TameableEntity {
    public static final String INIT_TAG = "ew_init";
    public static final float TICKS_PER_DAY = 24000f;
    public static final float MAX_DAYS = 125f;
    private static final TrackedData<Boolean> BREATHING =
            DataTracker.registerData(DragonEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final DragonElement element;
    public final AnimTracker anim = new AnimTracker();
    private int breathCooldown = 100;
    private int breathingTicks;
    private int ageAccumulator;

    public DragonEntity(EntityType<? extends DragonEntity> type, World world, DragonElement element) {
        super(type, world);
        this.element = element;
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 240.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.27)
                .add(EntityAttributes.ATTACK_DAMAGE, 26.0)
                .add(EntityAttributes.FOLLOW_RANGE, 32.0)
                .add(EntityAttributes.STEP_HEIGHT, 1.2)
                .add(EntityAttributes.SAFE_FALL_DISTANCE, 128.0);
    }

    // ------------------------------------------------------------------ edad y etapas
    /** Proporcion de la cria respecto al adulto (la escala minima del juego es 0.0625, asi que se sube en los modelos muy pequeños). */
    private double babyRatio() {
        return Math.max(0.14, 0.07 / this.element.adultScale);
    }

    public double scaleForDays(float days) {
        double r = this.babyRatio();
        return this.element.adultScale * (r + (1.0 - r) * Math.min(days, MAX_DAYS) / MAX_DAYS);
    }

    public float getAgeDays() {
        EntityAttributeInstance inst = this.getAttributeInstance(EntityAttributes.SCALE);
        double s = inst == null ? this.element.adultScale : inst.getBaseValue();
        double r = this.babyRatio();
        return (float) (((s / this.element.adultScale) - r) / (1.0 - r) * MAX_DAYS);
    }

    public void setAgeDays(float days) {
        EntityAttributeInstance inst = this.getAttributeInstance(EntityAttributes.SCALE);
        if (inst != null) inst.setBaseValue(scaleForDays(days));
        float f = Math.min(days, MAX_DAYS) / MAX_DAYS;
        EntityAttributeInstance hp = this.getAttributeInstance(EntityAttributes.MAX_HEALTH);
        if (hp != null) {
            float old = this.getMaxHealth();
            hp.setBaseValue(20.0 + 220.0 * f);
            float now = this.getMaxHealth();
            if (now > old) this.heal(now - old);
        }
        EntityAttributeInstance atk = this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE);
        if (atk != null) atk.setBaseValue(3.0 + 23.0 * f);
        EntityAttributeInstance armor = this.getAttributeInstance(EntityAttributes.ARMOR);
        if (armor != null) armor.setBaseValue(2.0 + 12.0 * f);
    }

    public int getStage() {
        float d = this.getAgeDays();
        return d < 25f ? 1 : d < 50f ? 2 : d < 75f ? 3 : d < 100f ? 4 : 5;
    }

    /** El sexo sale de la UUID: es estable, se guarda solo y no necesita datos extra. */
    public boolean isFemale() {
        return (this.getUuid().getLeastSignificantBits() & 1L) == 0L;
    }

    private Text info() {
        return Text.translatable("entity.emberwyrms.dragon.info", this.getStage(), Math.round(this.getAgeDays()),
                Text.translatable(this.isFemale() ? "entity.emberwyrms.dragon.female" : "entity.emberwyrms.dragon.male"));
    }

    // ------------------------------------------------------------------ datos y objetivos
    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(BREATHING, false);
    }

    public boolean isBreathing() {
        return this.dataTracker.get(BREATHING);
    }

    @Override
    public boolean isBaby() {
        return false;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new SitGoal(this));
        this.goalSelector.add(3, new MeleeAttackGoal(this, 1.2, true));
        this.goalSelector.add(4, new FollowOwnerGoal(this, 1.2, 10.0f, 3.0f));
        this.goalSelector.add(5, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 10.0f));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(3, new RevengeGoal(this));
        // los dragones que no son tuyos son hostiles (desde la etapa 3)
        this.targetSelector.add(4, new ActiveTargetGoal<>(this, PlayerEntity.class, true) {
            @Override
            public boolean canStart() {
                return !DragonEntity.this.isTamed() && DragonEntity.this.getStage() >= 3 && super.canStart();
            }
        });
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(ModItems.foodOf(this.element));   // cada elemento tiene su propia comida
    }

    // ------------------------------------------------------------------ tick
    @Override
    public void tick() {
        super.tick();
        this.anim.update(this);
        this.setNoGravity(this.getControllingPassenger() != null);
        World w = this.getEntityWorld();
        if (w.isClient() || !(w instanceof ServerWorld sw)) return;

        if (!this.getCommandTags().contains(INIT_TAG)) {
            this.addCommandTag(INIT_TAG);
            if (!this.isTamed()) this.setAgeDays(75f + this.random.nextFloat() * 50f);
        }
        if (++this.ageAccumulator >= 100) {
            this.ageAccumulator = 0;
            this.setAgeDays(this.getAgeDays() + 100f / TICKS_PER_DAY);
        }
        if (this.breathingTicks > 0 && --this.breathingTicks == 0) this.dataTracker.set(BREATHING, false);
        if (this.breathCooldown > 0) this.breathCooldown--;
        LivingEntity rider = this.getControllingPassenger();
        if (rider != null && this.breathCooldown <= 0) this.riderBreath(sw, rider);
        if (rider != null && !this.isOnGround() && this.age % 16 == 0) this.playSound(ModSounds.DRAGON_FLAP, 1.6f, 1.0f);
        LivingEntity t = this.getTarget();
        if (t != null && t.isAlive() && this.breathCooldown <= 0 && this.getStage() >= 2 && !this.isSitting()) {
            float d = this.distanceTo(t);
            if (d >= 3.0f && d <= 14.0f && this.canSee(t)) this.breathe(sw, t);
        }
    }

    private boolean isAlly(LivingEntity e) {
        if (e == this.getOwner()) return true;
        return e instanceof TameableEntity te && te.isTamed() && te.getOwner() == this.getOwner() && this.getOwner() != null;
    }

    private void breathe(ServerWorld sw, LivingEntity t) {
        this.breathCooldown = 60 + this.random.nextInt(40);
        this.breathingTicks = 15;
        this.dataTracker.set(BREATHING, true);
        this.playSound(ModSounds.DRAGON_BREATH, 1.8f, 0.9f);
        this.playSound(this.element.sound, 1.2f, 0.8f);

        Vec3d from = new Vec3d(this.getX(), this.getEyeY() - 0.2, this.getZ());
        Vec3d to = new Vec3d(t.getX(), t.getBodyY(0.5), t.getZ());
        Vec3d dir = to.subtract(from);
        double len = dir.length();
        Vec3d step = dir.normalize();
        for (double i = 1.5; i < len; i += 0.7) {
            sw.spawnParticles(this.element.particle, from.x + step.x * i, from.y + step.y * i, from.z + step.z * i,
                    3, 0.15, 0.15, 0.15, 0.01);
        }
        sw.spawnParticles(this.element.particle, to.x, to.y, to.z, 30, 1.0, 0.5, 1.0, 0.05);

        float power = 0.5f + 0.5f * Math.min(1f, this.getAgeDays() / 100f);
        Box box = t.getBoundingBox().expand(2.5);
        for (LivingEntity e : sw.getEntitiesByClass(LivingEntity.class, box, x -> x != this && !this.isAlly(x))) {
            e.damage(sw, sw.getDamageSources().mobAttack(this), this.element.damage * power);
            this.applyElementEffect(sw, e);
        }
    }

    private void applyElementEffect(ServerWorld sw, LivingEntity e) {
        switch (this.element) {
            case FIRE -> e.setOnFireFor(6.0f);
            case ICE -> {
                e.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 1));
                e.setFrozenTicks(200);
            }
            case STORM -> {
                LivingEntity owner = this.getOwner();
                boolean ownerClose = owner != null && owner.squaredDistanceTo(e) < 16.0;
                if (!ownerClose && this.random.nextInt(3) == 0) {
                    LightningEntity bolt = EntityType.LIGHTNING_BOLT.create(sw, SpawnReason.TRIGGERED);
                    if (bolt != null) {
                        bolt.setPosition(e.getX(), e.getY(), e.getZ());
                        sw.spawnEntity(bolt);
                    }
                }
            }
            case TIDE -> {
                e.addVelocity(0.0, 0.4, 0.0);
                e.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 1));
                e.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 0));
            }
        }
    }

    // ------------------------------------------------------------------ interaccion
    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        boolean server = !this.getEntityWorld().isClient();
        if (!this.isTamed() && this.isBreedingItem(stack)) {
            if (server) {
                stack.decrementUnlessCreative(1, player);
                if (this.random.nextInt(3) == 0) {
                    this.setOwner(player);
                    this.navigation.stop();
                    this.setTarget(null);
                    this.setSitting(true);
                    this.getEntityWorld().sendEntityStatus(this, (byte) 7);
                } else {
                    this.getEntityWorld().sendEntityStatus(this, (byte) 6);
                }
            }
            return ActionResult.SUCCESS;
        }
        if (this.isTamed() && this.isOwner(player) && stack.isOf(ModItems.ASH_HEART) && this.getAgeDays() < MAX_DAYS) {
            if (server) {
                stack.decrementUnlessCreative(1, player);
                this.setAgeDays(this.getAgeDays() + 25f);
                this.getEntityWorld().sendEntityStatus(this, (byte) 7);
                player.sendMessage(this.info(), true);
            }
            return ActionResult.SUCCESS;
        }
        if (this.isTamed() && (this.isBreedingItem(stack) || stack.isIn(ItemTags.MEAT)) && this.getHealth() < this.getMaxHealth()) {
            if (server) {
                stack.decrementUnlessCreative(1, player);
                this.heal(10.0f);
            }
            return ActionResult.SUCCESS;
        }
        if (this.isTamed() && this.isOwner(player) && stack.isEmpty() && hand == Hand.MAIN_HAND) {
            if (server) {
                if (player.isSneaking()) {
                    this.setSitting(!this.isSitting());
                    this.jumping = false;
                    this.navigation.stop();
                    this.setTarget(null);
                    player.sendMessage(this.info(), true);
                } else if (this.getStage() <= 2) {
                    player.sendMessage(this.info(), true);   // las crias todavia no se pueden montar
                } else {
                    this.setSitting(false);
                    player.startRiding(this);
                }
            }
            return ActionResult.SUCCESS;
        }
        return super.interactMob(player, hand);
    }

    @Override
    public boolean canBreedWith(AnimalEntity other) {
        if (other == this || !(other instanceof DragonEntity d) || d.element != this.element) return false;
        return this.isTamed() && d.isTamed() && this.getStage() >= 4 && d.getStage() >= 4
                && this.isFemale() != d.isFemale() && this.isInLove() && d.isInLove();
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity mate) {
        Entity e = this.getType().create(world, SpawnReason.BREEDING);
        if (e instanceof DragonEntity child) {
            child.addCommandTag(INIT_TAG);
            child.setAgeDays(0f);
            if (this.getOwner() instanceof PlayerEntity p) child.setOwner(p);
            return child;
        }
        return null;
    }

    /** Las hembras salvajes de etapa 4 y 5 pueden soltar un huevo al morir. */
    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);
        if (this.getEntityWorld() instanceof ServerWorld sw && !this.isTamed() && this.isFemale()
                && this.getStage() >= 4 && this.random.nextFloat() < 0.4f) {
            this.dropStack(sw, new ItemStack(ModItems.eggOf(this.element)));
        }
    }

    // ------------------------------------------------------------------ montura y vuelo (etapa 3+)
    @Override
    public LivingEntity getControllingPassenger() {
        return this.getFirstPassenger() instanceof PlayerEntity p ? p : null;
    }

    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return this.getPassengerList().isEmpty() && this.getStage() >= 3;
    }

    /** Con jinete: avanza hacia donde mira (W) incluyendo hacia arriba, asi que mirando arriba despega. */
    @Override
    public void travel(Vec3d input) {
        LivingEntity rider = this.getControllingPassenger();
        if (rider == null || !this.isAlive()) {
            super.travel(input);
            return;
        }
        this.setYaw(rider.getYaw());
        this.setPitch(rider.getPitch() * 0.5f);
        this.bodyYaw = this.getYaw();
        this.headYaw = this.getYaw();

        float fwd = rider.forwardSpeed;
        float side = rider.sidewaysSpeed * 0.5f;
        double yawRad = Math.toRadians(this.getYaw());
        Vec3d look = rider.getRotationVec(1.0f);
        double speed = 0.45 + 0.25 * Math.min(1f, this.getAgeDays() / 100f);
        Vec3d target = Vec3d.ZERO;
        if (fwd > 0) {
            target = look.multiply(speed * fwd);
        } else if (fwd < 0) {
            target = new Vec3d(look.x, 0, look.z).multiply(speed * 0.5 * fwd);
        }
        target = target.add(new Vec3d(Math.cos(yawRad), 0, Math.sin(yawRad)).multiply(side * speed));
        if (!this.isOnGround() && fwd == 0 && side == 0) {
            target = new Vec3d(0, -0.04, 0);
        }
        this.setVelocity(this.getVelocity().lerp(target, 0.15));
        this.move(MovementType.SELF, this.getVelocity());
    }

    private void riderBreath(ServerWorld sw, LivingEntity rider) {
        Vec3d look = rider.getRotationVec(1.0f);
        LivingEntity best = null;
        double bestD = 1e9;
        Box area = this.getBoundingBox().expand(18.0);
        for (LivingEntity e : sw.getEntitiesByClass(LivingEntity.class, area,
                x -> x instanceof Monster && x.isAlive() && x != this && !this.isAlly(x))) {
            Vec3d to = new Vec3d(e.getX() - this.getX(), e.getBodyY(0.5) - this.getEyeY(), e.getZ() - this.getZ());
            double d = to.length();
            if (d < 3.0 || d > 18.0) continue;
            if (to.normalize().dotProduct(look) < 0.75) continue;
            if (d < bestD) {
                bestD = d;
                best = e;
            }
        }
        if (best != null) this.breathe(sw, best);
    }

    @Override
    protected SoundEvent getAmbientSound() { return ModSounds.DRAGON_AMBIENT; }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) { return ModSounds.DRAGON_HURT; }

    @Override
    protected SoundEvent getDeathSound() { return ModSounds.DRAGON_DEATH; }
}
