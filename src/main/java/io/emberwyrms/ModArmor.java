package io.emberwyrms;

import java.util.Map;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;

/** 4 sets de armadura (fuego, hielo, rayo, agua) hechos con escamas de dragon. */
public class ModArmor {
    public static final String[] ELEMENTS = {"fire", "ice", "storm", "tide"};
    private static final String[] PARTS = {"helmet", "chestplate", "leggings", "boots"};
    private static final EquipmentType[] TYPES = {EquipmentType.HELMET, EquipmentType.CHESTPLATE, EquipmentType.LEGGINGS, EquipmentType.BOOTS};
    /** [elemento][casco, peto, pantalones, botas] */
    public static final Item[][] PIECES = new Item[4][4];

    private static ArmorMaterial material(String el) {
        RegistryKey<EquipmentAsset> asset = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Emberwyrms.id(el + "_dragon"));
        TagKey<Item> repair = TagKey.of(RegistryKeys.ITEM, Emberwyrms.id("repairs_" + el + "_dragon_armor"));
        return new ArmorMaterial(40,
                Map.of(EquipmentType.HELMET, 3, EquipmentType.CHESTPLATE, 8, EquipmentType.LEGGINGS, 6,
                        EquipmentType.BOOTS, 3, EquipmentType.BODY, 11),
                15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0f, 0.05f, repair, asset);
    }

    public static void register() {
        for (int e = 0; e < 4; e++) {
            ArmorMaterial mat = material(ELEMENTS[e]);
            for (int p = 0; p < 4; p++) {
                final EquipmentType type = TYPES[p];
                PIECES[e][p] = ModItems.reg(ELEMENTS[e] + "_dragon_" + PARTS[p], s -> new Item(s.armor(mat, type)));
            }
        }
    }
}
