package io.emberwyrms.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/** Jefe: Dragon de Ceniza. Aliento de fuego a distancia, pisotón que lanza por los aires y se enfurece a media vida. */
public class AshDragonEntity extends HostileEntity {
    private static final TrackedData<Boolean> BREATHING =
            DataTracker.registerData(AshDragonEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final AnimTracker anim = new AnimTracker();
    private final ServerBossBar bossBar = new ServerBossBar(Text.translatable("entity.emberwyrms.ash_dragon"),
            BossBar.Color.RED, BossBar.Style.PROGRESS);
    private int breathCooldown = 80;
    private int stompCooldown = 160;
    private int breathingTicks;

    public AshDragonEntity(EntityType<? extends AshDragonEntity> type, World world) {
        super(type, world);
        this.setPersistent();
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.MAX_HEALTH, 400.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.3)
                .add(EntityAttributes.ATTACK_DAMAGE, 16.0)
                .add(EntityAttributes.FOLLOW_RANGE, 48.0)
                .add(EntityAttributes.ARMOR, 10.0)
                .add(EntityAttributes.KNOCKBACK_RESISTANCE, 1.0)
                .add(EntityAttributes.STEP_HEIGHT, 2.0)
                .add(EntityAttributes.SCALE, 1.7);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(BREATHING, false);
    }

    public boolean isBreathing() {
        return this.dataTracker.get(BREATHING);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.1, true));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.7));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 24.0f));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public void tick() {
        super.tick();
        this.anim.update(this);
        World w = this.getEntityWorld();
        if (w.isClient() || !(w instanceof ServerWorld sw)) return;

        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
        boolean enraged = this.getHealth() < this.getMaxHealth() * 0.5f;
        if (this.breathingTicks > 0 && --this.breathingTicks == 0) this.dataTracker.set(BREATHING, false);
        if (this.breathCooldown > 0) this.breathCooldown--;
        if (this.stompCooldown > 0) this.stompCooldown--;
        if (enraged && this.age % 20 == 0) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 40, 1));
        }
        LivingEntity t = this.getTarget();
        if (t != null && t.isAlive()) {
            float d = this.distanceTo(t);
            if (this.breathCooldown <= 0 && d >= 4.0f && d <= 26.0f && this.canSee(t)) {
                this.breathe(sw, t, enraged);
            } else if (this.stompCooldown <= 0 && d <= 9.0f) {
                this.stomp(sw, enraged);
            }
        }
    }

    private void breathe(ServerWorld sw, LivingEntity t, boolean enraged) {
        this.breathCooldown = enraged ? 50 : 90;
        this.breathingTicks = 20;
        this.dataTracker.set(BREATHING, true);
        this.playSound(SoundEvents.ENTITY_ENDER_DRAGON_GROWL, 2.0f, 0.7f);

        Vec3d from = new Vec3d(this.getX(), this.getEyeY() - 0.3, this.getZ());
        Vec3d to = new Vec3d(t.getX(), t.getBodyY(0.5), t.getZ());
        Vec3d dir = to.subtract(from);
        double len = dir.length();
        Vec3d step = dir.normalize();
        for (double i = 2.0; i < len; i += 0.6) {
            sw.spawnParticles(ParticleTypes.FLAME, from.x + step.x * i, from.y + step.y * i, from.z + step.z * i, 4, 0.25, 0.25, 0.25, 0.02);
            sw.spawnParticles(ParticleTypes.LARGE_SMOKE, from.x + step.x * i, from.y + step.y * i, from.z + step.z * i, 1, 0.2, 0.2, 0.2, 0.01);
        }
        sw.spawnParticles(ParticleTypes.FLAME, to.x, to.y, to.z, 50, 1.4, 0.6, 1.4, 0.06);

        Box box = t.getBoundingBox().expand(3.0);
        for (LivingEntity e : sw.getEntitiesByClass(LivingEntity.class, box, x -> x != this && !(x instanceof AshDragonEntity))) {
            e.damage(sw, sw.getDamageSources().mobAttack(this), enraged ? 18.0f : 14.0f);
            e.setOnFireFor(8.0f);
        }
    }

    private void stomp(ServerWorld sw, boolean enraged) {
        this.stompCooldown = enraged ? 140 : 240;
        this.playSound(SoundEvents.ENTITY_ENDER_DRAGON_GROWL, 2.0f, 0.5f);
        for (int k = 0; k < 24; k++) {
            double a = k * Math.PI / 12.0;
            for (double r : new double[]{3.0, 6.0}) {
                sw.spawnParticles(ParticleTypes.LARGE_SMOKE, this.getX() + Math.cos(a) * r, this.getY() + 0.2, this.getZ() + Math.sin(a) * r, 2, 0.1, 0.1, 0.1, 0.02);
                sw.spawnParticles(ParticleTypes.FLAME, this.getX() + Math.cos(a) * r, this.getY() + 0.2, this.getZ() + Math.sin(a) * r, 1, 0.1, 0.1, 0.1, 0.02);
            }
        }
        Box box = this.getBoundingBox().expand(9.0, 2.0, 9.0);
        for (LivingEntity e : sw.getEntitiesByClass(LivingEntity.class, box, x -> x != this && !(x instanceof AshDragonEntity))) {
            double dx = e.getX() - this.getX();
            double dz = e.getZ() - this.getZ();
            double len = Math.max(0.1, Math.sqrt(dx * dx + dz * dz));
            e.damage(sw, sw.getDamageSources().mobAttack(this), 10.0f);
            e.addVelocity(dx / len * 1.1, 0.7, dz / len * 1.1);
        }
    }

    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    @Override
    public void remove(Entity.RemovalReason reason) {
        super.remove(reason);
        this.bossBar.clearPlayers();
    }

    @Override
    protected SoundEvent getAmbientSound() { return SoundEvents.ENTITY_ENDER_DRAGON_GROWL; }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) { return SoundEvents.ENTITY_ENDER_DRAGON_HURT; }

    @Override
    protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_ENDER_DRAGON_DEATH; }
}
