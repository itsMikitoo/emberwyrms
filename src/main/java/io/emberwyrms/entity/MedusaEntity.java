package io.emberwyrms.entity;

import io.emberwyrms.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MedusaEntity extends HostileEntity {
    public MedusaEntity(EntityType<? extends MedusaEntity> type, World world) {
        super(type, world);
    }

    public final AnimTracker anim = new AnimTracker();

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.MAX_HEALTH, 40.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.26)
                .add(EntityAttributes.ATTACK_DAMAGE, 6.0)
                .add(EntityAttributes.FOLLOW_RANGE, 24.0)
                .add(EntityAttributes.SCALE, 0.8);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.1, false));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 12.0f));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    /** Mirada petrificante: si el jugador mira a Medusa de frente, queda casi inmovil. */
    @Override
    public void tick() {
        super.tick();
        this.anim.update(this);
        if (!this.getEntityWorld().isClient() && this.age % 20 == 0 && this.getTarget() instanceof PlayerEntity p) {
            if (this.distanceTo(p) < 14.0f && this.canSee(p)) {
                Vec3d look = p.getRotationVec(1.0f).normalize();
                Vec3d toMe = new Vec3d(this.getX() - p.getX(), this.getEyeY() - p.getEyeY(), this.getZ() - p.getZ()).normalize();
                if (look.dotProduct(toMe) > 0.9) {
                    p.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 80, 3));
                    p.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 80, 1));
                    p.sendMessage(Text.translatable("entity.emberwyrms.medusa.gaze"), true);
                }
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() { return ModSounds.MEDUSA_AMBIENT; }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) { return ModSounds.MEDUSA_HURT; }

    @Override
    protected SoundEvent getDeathSound() { return ModSounds.MEDUSA_DEATH; }
}
