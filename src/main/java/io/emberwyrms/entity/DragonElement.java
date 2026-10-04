package io.emberwyrms.entity;

import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public enum DragonElement {
    // adultScale = escala del adulto; hitW/hitH = caja de golpe a escala 1; seatY = altura del asiento a escala 1
    FIRE("fire", ParticleTypes.FLAME, 6.0f, SoundEvents.ENTITY_BLAZE_SHOOT, 0.65f, 4.6f, 4.0f, 4.55f),
    ICE("ice", ParticleTypes.SNOWFLAKE, 5.0f, SoundEvents.ENTITY_PLAYER_HURT_FREEZE, 0.32f, 8.7f, 7.5f, 8.1f),
    STORM("storm", ParticleTypes.ELECTRIC_SPARK, 7.0f, SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT, 1.5f, 2.0f, 1.5f, 1.9f),
    TIDE("tide", ParticleTypes.SPLASH, 5.0f, SoundEvents.ENTITY_DOLPHIN_SPLASH, 1.4f, 1.45f, 1.45f, 1.8f);

    public final String id;
    public final ParticleEffect particle;
    public final float damage;
    public final SoundEvent sound;
    public final float adultScale;
    public final float hitW;
    public final float hitH;
    public final float seatY;

    DragonElement(String id, ParticleEffect particle, float damage, SoundEvent sound, float adultScale, float hitW, float hitH, float seatY) {
        this.adultScale = adultScale;
        this.hitW = hitW;
        this.hitH = hitH;
        this.seatY = seatY;
        this.id = id;
        this.particle = particle;
        this.damage = damage;
        this.sound = sound;
    }
}
