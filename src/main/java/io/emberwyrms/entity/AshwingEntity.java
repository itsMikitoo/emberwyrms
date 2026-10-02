package io.emberwyrms.entity;

import io.emberwyrms.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
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
import net.minecraft.world.World;

/** Fase 1: dragon terrestre domesticable (carne cruda). Vuelo y montura llegan en la fase 2. */
public class AshwingEntity extends TameableEntity {
    public AshwingEntity(EntityType<? extends AshwingEntity> type, World world) {
        super(type, world);
    }

    public final AnimTracker anim = new AnimTracker();

    @Override
    public void tick() {
        super.tick();
        this.anim.update(this);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 60.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.28)
                .add(EntityAttributes.ATTACK_DAMAGE, 8.0)
                .add(EntityAttributes.FOLLOW_RANGE, 32.0)
                .add(EntityAttributes.STEP_HEIGHT, 1.1)
                .add(EntityAttributes.SCALE, 1.2);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new SitGoal(this));
        this.goalSelector.add(3, new MeleeAttackGoal(this, 1.2, true));
        this.goalSelector.add(4, new FollowOwnerGoal(this, 1.2, 10.0f, 3.0f));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 10.0f));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(3, new RevengeGoal(this));
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isIn(ItemTags.MEAT);
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
                this.setSitting(!this.isSitting());
                this.jumping = false;
                this.navigation.stop();
                this.setTarget(null);
            }
            return ActionResult.SUCCESS;
        }
        return super.interactMob(player, hand);
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity other) {
        return null; // la cria llega con el ciclo de vida (fase 2)
    }

    @Override
    protected SoundEvent getAmbientSound() { return ModSounds.DRAGON_AMBIENT; }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) { return ModSounds.DRAGON_HURT; }

    @Override
    protected SoundEvent getDeathSound() { return ModSounds.DRAGON_DEATH; }

    @Override
    public boolean canBeLeashed() { return false; }
}
