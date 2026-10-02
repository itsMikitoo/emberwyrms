package io.emberwyrms.entity;

import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public enum DragonElement {
    FIRE("fire", ParticleTypes.FLAME, 6.0f, SoundEvents.ENTITY_BLAZE_SHOOT),
    ICE("ice", ParticleTypes.SNOWFLAKE, 5.0f, SoundEvents.ENTITY_PLAYER_HURT_FREEZE),
    STORM("storm", ParticleTypes.ELECTRIC_SPARK, 7.0f, SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT),
    TIDE("tide", ParticleTypes.SPLASH, 5.0f, SoundEvents.ENTITY_DOLPHIN_SPLASH);

    public final String id;
    public final ParticleEffect particle;
    public final float damage;
    public final SoundEvent sound;

    DragonElement(String id, ParticleEffect particle, float damage, SoundEvent sound) {
        this.id = id;
        this.particle = particle;
        this.damage = damage;
        this.sound = sound;
    }
}
