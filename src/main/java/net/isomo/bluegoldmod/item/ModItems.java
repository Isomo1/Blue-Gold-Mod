package net.isomo.bluegoldmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.isomo.bluegoldmod.BlueGoldMod;
import net.isomo.bluegoldmod.item.custom.ModArmorItem;
import net.isomo.bluegoldmod.item.custom.ModAxeItem;
import net.isomo.bluegoldmod.item.custom.ModHoeItem;
import net.isomo.bluegoldmod.item.custom.ModPickaxeItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item BLUE_GOLD_INGOT = registerItem("blue_gold_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_NUGGET = registerItem("blue_gold_nugget",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item RAW_BLUE_GOLD = registerItem("raw_blue_gold",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item IRON_HANDLE = registerItem("iron_handle",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item REINFORCED_SWORD_HANDLE = registerItem("reinforced_sword_handle",
            new SwordItem(ModToolMaterial.REACTIVE_NETHERITE,-5,-2.6f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item LEATHER_STRIPS = registerItem("leather_strips",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item UNIVERSAL_CORE = registerItem("universal_core",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GLASS = registerItem("blue_glass",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item REACTIVE_NETHERITE_INGOT = registerItem("reactive_netherite_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_SWORD = registerItem("blue_gold_sword",
            new SwordItem(ModToolMaterial.BLUE_GOLD,3,-2.4f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item REINFORCED_BLUE_GOLD_SWORD = registerItem("reinforced_blue_gold_sword",
            new SwordItem(ModToolMaterial.REACTIVE_NETHERITE,14,-3.2f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_SHOVEL = registerItem("blue_gold_shovel",
            new ShovelItem(ModToolMaterial.BLUE_GOLD,1.5f,-3.0f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_PICKAXE = registerItem("blue_gold_pickaxe",
            new ModPickaxeItem(ModToolMaterial.BLUE_GOLD,1,-2.8f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_AXE = registerItem("blue_gold_axe",
            new ModAxeItem(ModToolMaterial.BLUE_GOLD,5.5f,-3.05f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_HOE = registerItem("blue_gold_hoe",
            new ModHoeItem(ModToolMaterial.BLUE_GOLD,-2,-0.5f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GLASS_GOGGLES = registerItem("blue_glass_goggles",
            new ModArmorItem(ModArmorMaterial.BLUE_GLASS, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_HELMET = registerItem("blue_gold_helmet",
            new ArmorItem(ModArmorMaterial.BLUE_GOLD, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_CHESTPLATE = registerItem("blue_gold_chestplate",
            new ArmorItem(ModArmorMaterial.BLUE_GOLD, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_LEGGINGS = registerItem("blue_gold_leggings",
            new ArmorItem(ModArmorMaterial.BLUE_GOLD, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_BOOTS = registerItem("blue_gold_boots",
            new ArmorItem(ModArmorMaterial.BLUE_GOLD, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(BlueGoldMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        BlueGoldMod.LOGGER.info("Registering Mod Items for "+ BlueGoldMod.MOD_ID);
    }
}
