package io.emberwyrms;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

/** Sonidos propios (los .ogg se sintetizan al compilar con tools/gen_sounds.py). */
public class ModSounds {
    public static final SoundEvent DRAGON_AMBIENT = reg("entity.dragon.ambient");
    public static final SoundEvent DRAGON_HURT = reg("entity.dragon.hurt");
    public static final SoundEvent DRAGON_DEATH = reg("entity.dragon.death");
    public static final SoundEvent DRAGON_ROAR = reg("entity.dragon.roar");
    public static final SoundEvent DRAGON_BREATH = reg("entity.dragon.breath");
    public static final SoundEvent DRAGON_FLAP = reg("entity.dragon.flap");
    public static final SoundEvent PHOENIX_AMBIENT = reg("entity.phoenix.ambient");
    public static final SoundEvent PHOENIX_HURT = reg("entity.phoenix.hurt");
    public static final SoundEvent PHOENIX_DEATH = reg("entity.phoenix.death");
    public static final SoundEvent MEDUSA_AMBIENT = reg("entity.medusa.ambient");
    public static final SoundEvent MEDUSA_HURT = reg("entity.medusa.hurt");
    public static final SoundEvent MEDUSA_DEATH = reg("entity.medusa.death");

    private static SoundEvent reg(String name) {
        Identifier id = Emberwyrms.id(name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void register() {
    }
}
