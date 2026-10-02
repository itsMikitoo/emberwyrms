package io.emberwyrms;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;

/** Bonus por set completo de escamas: fuego = inmune al fuego, hielo = resistencia, rayo = velocidad, agua = respirar bajo el agua. */
public class ArmorPerks {
    private static boolean fullSet(ServerPlayerEntity p, int e) {
        return p.getEquippedStack(EquipmentSlot.HEAD).isOf(ModArmor.PIECES[e][0])
                && p.getEquippedStack(EquipmentSlot.CHEST).isOf(ModArmor.PIECES[e][1])
                && p.getEquippedStack(EquipmentSlot.LEGS).isOf(ModArmor.PIECES[e][2])
                && p.getEquippedStack(EquipmentSlot.FEET).isOf(ModArmor.PIECES[e][3]);
    }

    private static StatusEffectInstance fx(net.minecraft.registry.entry.RegistryEntry<net.minecraft.entity.effect.StatusEffect> effect, int amp) {
        return new StatusEffectInstance(effect, 100, amp, true, false, true);
    }

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            if (server.getTicks() % 20 != 0) return;
            for (ServerPlayerEntity p : server.getPlayerManager().getPlayerList()) {
                if (fullSet(p, 0)) p.addStatusEffect(fx(StatusEffects.FIRE_RESISTANCE, 0));
                if (fullSet(p, 1)) p.addStatusEffect(fx(StatusEffects.RESISTANCE, 0));
                if (fullSet(p, 2)) p.addStatusEffect(fx(StatusEffects.SPEED, 0));
                if (fullSet(p, 3)) {
                    p.addStatusEffect(fx(StatusEffects.WATER_BREATHING, 0));
                    p.addStatusEffect(fx(StatusEffects.DOLPHINS_GRACE, 0));
                }
            }
        });
    }
}
