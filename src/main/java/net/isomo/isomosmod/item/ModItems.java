package net.isomo.isomosmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.isomo.isomosmod.IsomosMod;
import net.isomo.isomosmod.item.custom.ModAxeItem;
import net.isomo.isomosmod.item.custom.ModHoeItem;
import net.isomo.isomosmod.item.custom.ModPickaxeItem;
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

    public static final Item BLUE_GOLD_SWORD = registerItem("blue_gold_sword",
            new SwordItem(ModToolMaterial.BLUE_GOLD,3,-2.4f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item REINFORCED_BLUE_GOLD_SWORD = registerItem("reinforced_blue_gold_sword",
            new SwordItem(ModToolMaterial.BLUE_GOLD,9,-0.4f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_SHOVEL = registerItem("blue_gold_shovel",
            new ShovelItem(ModToolMaterial.BLUE_GOLD,1.5f,-3.0f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_PICKAXE = registerItem("blue_gold_pickaxe",
            new ModPickaxeItem(ModToolMaterial.BLUE_GOLD,1,-2.8f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_AXE = registerItem("blue_gold_axe",
            new ModAxeItem(ModToolMaterial.BLUE_GOLD,5.5f,-3.05f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    public static final Item BLUE_GOLD_HOE = registerItem("blue_gold_hoe",
            new ModAxeItem(ModToolMaterial.BLUE_GOLD,-2.5f,-0.5f,new FabricItemSettings().group(ModItemGroup.BLUEGOLD)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(IsomosMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        IsomosMod.LOGGER.info("Registering Mod Items for "+IsomosMod.MOD_ID);
    }
}
