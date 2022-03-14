package net.isomo.bluegoldmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.isomo.bluegoldmod.BlueGoldMod;
import net.isomo.bluegoldmod.item.custom.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item REINFORCED_BLUE_GOLD_INGOT = registerItem("reinforced_blue_gold_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_INGOT = registerItem("blue_gold_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_NUGGET = registerItem("blue_gold_nugget",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item RADIANT_DUST = registerItem("radiant_dust",
            new DustItem(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item INDIGO_DIAMOND = registerItem("indigo_diamond",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item IRON_HANDLE = registerItem("iron_handle",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item LEATHER_STRIPS = registerItem("leather_strips",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item AZURE_GLASS = registerItem("azure_glass",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item AZURE_GLASS_PIECES = registerItem("azure_glass_pieces",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item UNIVERSAL_CORE = registerItem("universal_core",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item ESSENTIAL_CORE = registerItem("essential_core",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item DEVICE_BATTERY = registerItem("device_battery",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item CAMOUFLAGE_DEVICE = registerItem("camouflage_device",
            new CamouflageDevice(new FabricItemSettings().group(ModItemGroup.BLUEGOLD).maxDamage(1000)));

    public static final Item TELEPORTATION_DEVICE = registerItem("teleportation_device",
            new TeleportationDevice(new FabricItemSettings().group(ModItemGroup.BLUEGOLD).maxDamage(2000)));

    public static final Item SAFETY_DEVICE = registerItem("safety_device",
            new SafetyDevice(new FabricItemSettings().group(ModItemGroup.BLUEGOLD).maxDamage(2000)));

    public static final Item PROPULSION_DEVICE = registerItem("propulsion_device",
            new PropulsionDevice(new FabricItemSettings().group(ModItemGroup.BLUEGOLD).maxDamage(1000)));

    public static final Item DEBUFF_STICK = registerItem("debuff_stick",
            new DebuffStick(ModToolMaterial.DEBUFF,0,1.0f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLESSED_AMULET = registerItem("blessed_amulet",
            new BlessedAmulet(new FabricItemSettings().group(ModItemGroup.BLUEGOLD).maxDamage(50)));

    public static final Item AZURE_GLASS_GOGGLES = registerItem("azure_glass_goggles",
            new GogglesItem(ModArmorMaterial.AZURE_GLASS, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item NIMBLE_BOOTS = registerItem("nimble_boots",
            new NimbleBoots(ModArmorMaterial.AZURE_GLASS, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item PERFECT_BOOTS = registerItem("perfect_boots",
            new PerfectBoots(ModArmorMaterial.UNIVERSAL_CORE, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_SWORD = registerItem("blue_gold_sword",
            new SwordItem(ModToolMaterial.BLUE_GOLD,3,-2.4f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_PICKAXE = registerItem("blue_gold_pickaxe",
            new ModPickaxeItem(ModToolMaterial.BLUE_GOLD,1,-2.8f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_AXE = registerItem("blue_gold_axe",
            new ModAxeItem(ModToolMaterial.BLUE_GOLD,5.5f,-3.05f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_SHOVEL = registerItem("blue_gold_shovel",
            new ShovelItem(ModToolMaterial.BLUE_GOLD,1.5f,-3.0f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_HOE = registerItem("blue_gold_hoe",
            new ModHoeItem(ModToolMaterial.BLUE_GOLD,-2,-0.5f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_HELMET = registerItem("blue_gold_helmet",
            new ArmorItem(ModArmorMaterial.BLUE_GOLD, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_CHESTPLATE = registerItem("blue_gold_chestplate",
            new ArmorItem(ModArmorMaterial.BLUE_GOLD, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_LEGGINGS = registerItem("blue_gold_leggings",
            new ArmorItem(ModArmorMaterial.BLUE_GOLD, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_BOOTS = registerItem("blue_gold_boots",
            new ArmorItem(ModArmorMaterial.BLUE_GOLD, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_HORSE_ARMOR = registerItem("blue_gold_horse_armor",
            new HorseArmorItem(8,"blue_gold",new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item REINFORCED_BLUE_GOLD_SWORD = registerItem("reinforced_blue_gold_sword",
            new ModReinforcedSwordItem(ModToolMaterial.REINFORCED_BLUE_GOLD,11,-2.4f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item REINFORCED_BLUE_GOLD_PICKAXE = registerItem("reinforced_blue_gold_pickaxe",
            new ModReinforcedPickaxeItem(ModToolMaterial.REINFORCED_BLUE_GOLD,1,-2.8f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item REINFORCED_BLUE_GOLD_AXE = registerItem("reinforced_blue_gold_axe",
            new ModReinforcedAxeItem(ModToolMaterial.REINFORCED_BLUE_GOLD,5,-3,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item REINFORCED_BLUE_GOLD_SHOVEL = registerItem("reinforced_blue_gold_shovel",
            new ModReinforcedShovelItem(ModToolMaterial.REINFORCED_BLUE_GOLD,1.5f,-3.0f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item REINFORCED_BLUE_GOLD_HOE = registerItem("reinforced_blue_gold_hoe",
            new ModReinforcedHoeItem(ModToolMaterial.REINFORCED_BLUE_GOLD,-4,0.0f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item REINFORCED_BLUE_GOLD_HELMET = registerItem("reinforced_blue_gold_helmet",
            new ArmorItem(ModArmorMaterial.REINFORCED_BLUE_GOLD, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item REINFORCED_BLUE_GOLD_HELMET_UPGRADED = registerItem("reinforced_blue_gold_helmet_upgraded",
            new UpgradedHelmet(ModArmorMaterial.REINFORCED_BLUE_GOLD, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item REINFORCED_BLUE_GOLD_CHESTPLATE = registerItem("reinforced_blue_gold_chestplate",
            new ArmorItem(ModArmorMaterial.REINFORCED_BLUE_GOLD, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item REINFORCED_BLUE_GOLD_LEGGINGS = registerItem("reinforced_blue_gold_leggings",
            new ArmorItem(ModArmorMaterial.REINFORCED_BLUE_GOLD, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item REINFORCED_BLUE_GOLD_BOOTS = registerItem("reinforced_blue_gold_boots",
            new ArmorItem(ModArmorMaterial.REINFORCED_BLUE_GOLD, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item REINFORCED_BLUE_GOLD_BOOTS_UPGRADED = registerItem("reinforced_blue_gold_boots_upgraded",
            new UpgradedBoots(ModArmorMaterial.REINFORCED_BLUE_GOLD, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item ARKHALITZ = registerItem("arkhalitz",
            new Arkhalitz(ModToolMaterial.ARKHALITZ,48,-3.5f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD).maxDamage(4561)));

    public static final Item CORRUPTED_SWORD = registerItem("corrupted_sword",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD).maxDamage(1)));

    public static final Item CORRUPTED_STAR = registerItem("corrupted_star",
            new Item(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item ABOMINATION_SOUL = registerItem("abomination_soul",
            new SoulItem(new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));



    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(BlueGoldMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        BlueGoldMod.LOGGER.info("Registering Mod Items for "+ BlueGoldMod.MOD_ID);
    }
}
