package io.emberwyrms.entity;

import io.emberwyrms.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

/** Fase 1: fenix volador domesticable con polvo de blaze. */
public class PhoenixEntity extends TameableEntity {
    public PhoenixEntity(EntityType<? extends PhoenixEntity> type, World world) {
        super(type, world);
        this.moveControl = new FlightMoveControl(this, 10, false);
    }

    public final AnimTracker anim = new AnimTracker();

    @Override
    public void tick() {
        super.tick();
        this.anim.update(this);
        if (this.getEntityWorld() instanceof net.minecraft.server.world.ServerWorld sw && this.age % 3 == 0) {
            // estela de fuego: el fenix deja chispas y brasas a su paso
            sw.spawnParticles(net.minecraft.particle.ParticleTypes.FLAME, this.getX(), this.getY() + 1.2, this.getZ(), 2, 0.9, 0.6, 0.9, 0.01);
            if (this.age % 9 == 0) sw.spawnParticles(net.minecraft.particle.ParticleTypes.LAVA, this.getX(), this.getY() + 1.0, this.getZ(), 1, 0.6, 0.3, 0.6, 0.0);
        }
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 24.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.FLYING_SPEED, 0.6)
                .add(EntityAttributes.ATTACK_DAMAGE, 4.0)
                .add(EntityAttributes.SAFE_FALL_DISTANCE, 64.0)
                .add(EntityAttributes.SCALE, 1.8);
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        BirdNavigation nav = new BirdNavigation(this, world);
        nav.setCanOpenDoors(false);
        nav.setCanSwim(true);
        return nav;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new SitGoal(this));
        this.goalSelector.add(3, new FollowOwnerGoal(this, 1.2, 8.0f, 3.0f));
        this.goalSelector.add(4, new FlyGoal(this, 1.0));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.BLAZE_POWDER);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if (this.isBreedingItem(stack)) {
            if (!this.getEntityWorld().isClient()) {
                stack.decrementUnlessCreative(1, player);
                if (!this.isTamed()) {
                    if (this.random.nextInt(3) == 0) {
                        this.setOwner(player);
                        this.setSitting(false);
                        this.getEntityWorld().sendEntityStatus(this, (byte) 7);
                    } else {
                        this.getEntityWorld().sendEntityStatus(this, (byte) 6);
                    }
                } else {
                    this.heal(8.0f);
                }
            }
            return ActionResult.SUCCESS;
        }
        if (this.isTamed() && this.isOwner(player) && stack.isEmpty() && hand == Hand.MAIN_HAND) {
            if (!this.getEntityWorld().isClient()) {
                this.setSitting(!this.isSitting());
                this.navigation.stop();
            }
            return ActionResult.SUCCESS;
        }
        return super.interactMob(player, hand);
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity other) {
        return null; // el huevo de fenix llega en la fase 3
    }

    @Override
    protected SoundEvent getAmbientSound() { return ModSounds.PHOENIX_AMBIENT; }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) { return ModSounds.PHOENIX_HURT; }

    @Override
    protected SoundEvent getDeathSound() { return ModSounds.PHOENIX_DEATH; }
}
