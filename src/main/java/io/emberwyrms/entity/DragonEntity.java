package io.emberwyrms.entity;

import java.util.UUID;
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
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/** Dragon elemental (fuego, hielo, rayo, agua). Cria -> adulto. Aliento con efecto segun elemento. */
public class DragonEntity extends TameableEntity {
    /** Ticks que tarda una cria en hacerse adulta (24000 = 20 minutos). */
    public static final int GROW_TICKS = 24000;
    private static final TrackedData<Boolean> BREATHING =
            DataTracker.registerData(DragonEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final DragonElement element;
    public final AnimTracker anim = new AnimTracker();
    private int breathCooldown = 100;
    private int breathingTicks;

    public DragonEntity(EntityType<? extends DragonEntity> type, World world, DragonElement element) {
        super(type, world);
        this.element = element;
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 80.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.27)
                .add(EntityAttributes.ATTACK_DAMAGE, 10.0)
                .add(EntityAttributes.FOLLOW_RANGE, 32.0)
                .add(EntityAttributes.STEP_HEIGHT, 1.2)
                .add(EntityAttributes.SAFE_FALL_DISTANCE, 128.0);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(BREATHING, false);
    }

    public boolean isBreathing() {
        return this.dataTracker.get(BREATHING);
    }

    /** Las crias se escalan con el atributo SCALE, asi que desactivamos el "bebe" de vanilla. */
    @Override
    public boolean isBaby() {
        return false;
    }

    public boolean isHatchling() {
        return this.getBreedingAge() < 0;
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
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isIn(ItemTags.MEAT);
    }

    @Override
    public void tick() {
        super.tick();
        this.anim.update(this);
        this.setNoGravity(this.getControllingPassenger() != null);
        World w = this.getEntityWorld();
        if (!w.isClient() && w instanceof ServerWorld sw) {
            this.updateGrowthScale();
            if (this.breathingTicks > 0 && --this.breathingTicks == 0) {
                this.dataTracker.set(BREATHING, false);
            }
            if (this.breathCooldown > 0) this.breathCooldown--;
            LivingEntity rider = this.getControllingPassenger();
            if (rider != null && this.breathCooldown <= 0) this.riderBreath(sw, rider);
            LivingEntity t = this.getTarget();
            if (t != null && t.isAlive() && this.breathCooldown <= 0 && !this.isHatchling() && !this.isSitting()) {
                float d = this.distanceTo(t);
                if (d >= 3.0f && d <= 14.0f && this.canSee(t)) this.breathe(sw, t);
            }
        }
    }

    private void updateGrowthScale() {
        int age = this.getBreedingAge();
        float g = age < 0 ? 0.35f + 0.65f * (1f + age / (float) GROW_TICKS) : 1f;
        g = Math.max(0.35f, Math.min(1f, g));
        EntityAttributeInstance inst = this.getAttributeInstance(EntityAttributes.SCALE);
        if (inst != null && Math.abs(inst.getBaseValue() - g) > 0.01) inst.setBaseValue(g);
    }

    private boolean isAlly(LivingEntity e) {
        if (e == this.getOwner()) return true;
        return e instanceof TameableEntity te && te.isTamed() && te.getOwner() == this.getOwner() && this.getOwner() != null;
    }

    private void breathe(ServerWorld sw, LivingEntity t) {
        this.breathCooldown = 60 + this.random.nextInt(40);
        this.breathingTicks = 15;
        this.dataTracker.set(BREATHING, true);
        this.playSound(this.element.sound, 1.5f, 0.8f);

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

        Box box = t.getBoundingBox().expand(2.5);
        for (LivingEntity e : sw.getEntitiesByClass(LivingEntity.class, box, x -> x != this && !this.isAlly(x))) {
            e.damage(sw, sw.getDamageSources().mobAttack(this), this.element.damage);
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

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if (!this.isTamed() && this.isBreedingItem(stack)) {
            if (!this.getEntityWorld().isClient()) {
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
        if (this.isTamed() && this.isBreedingItem(stack) && this.getHealth() < this.getMaxHealth()) {
            if (!this.getEntityWorld().isClient()) {
                stack.decrementUnlessCreative(1, player);
                this.heal(10.0f);
            }
            return ActionResult.SUCCESS;
        }
        if (this.isTamed() && this.isOwner(player) && stack.isEmpty() && hand == Hand.MAIN_HAND) {
            if (!this.getEntityWorld().isClient()) {
                if (player.isSneaking() || this.isHatchling()) {
                    this.setSitting(!this.isSitting());
                    this.jumping = false;
                    this.navigation.stop();
                    this.setTarget(null);
                } else {
                    this.setSitting(false);
                    player.startRiding(this);
                }
            }
            return ActionResult.SUCCESS;
        }
        return super.interactMob(player, hand);
    }

    // ------------------------------------------------------------------ montura y vuelo
    @Override
    public LivingEntity getControllingPassenger() {
        return this.getFirstPassenger() instanceof PlayerEntity p ? p : null;
    }

    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return this.getPassengerList().isEmpty() && !this.isHatchling();
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
        double speed = 0.6;
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

    /** Ayuda de punteria: si montas, escupe aliento al monstruo mas cercano al que miras. */
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
    public PassiveEntity createChild(ServerWorld world, PassiveEntity mate) {
        Entity e = this.getType().create(world, SpawnReason.BREEDING);
        if (e instanceof DragonEntity child) {
            if (this.getOwner() instanceof PlayerEntity p) child.setOwner(p);
            return child;
        }
        return null;
    }

    @Override
    protected SoundEvent getAmbientSound() { return SoundEvents.ENTITY_ENDER_DRAGON_GROWL; }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) { return SoundEvents.ENTITY_ENDER_DRAGON_HURT; }

    @Override
    protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_ENDER_DRAGON_DEATH; }
}
