package net.isomo.bluegoldmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.isomo.bluegoldmod.BlueGoldMod;
import net.isomo.bluegoldmod.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block BLUE_GOLD_ORE = registerBlock("blue_gold_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool().luminance(5)), ModItemGroup.BLUEGOLD);

    public static final Block DEEPSLATE_BLUE_GOLD_ORE = registerBlock("deepslate_blue_gold_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool().luminance(5)), ModItemGroup.BLUEGOLD);

    public static final Block NETHER_BLUE_GOLD_ORE = registerBlock("nether_blue_gold_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool().luminance(5)), ModItemGroup.BLUEGOLD);

    public static final Block RAW_BLUE_GOLD_BLOCK = registerBlock("raw_blue_gold_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().luminance(6)), ModItemGroup.BLUEGOLD);

    public static final Block BLUE_GOLD_BLOCK = registerBlock("blue_gold_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6.0f).requiresTool().luminance(8)), ModItemGroup.BLUEGOLD);

    public static final Block REACTIVE_NETHERITE_BLOCK = registerBlock("reactive_netherite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(7.0f).requiresTool().luminance(12)), ModItemGroup.BLUEGOLD);

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name,block,group);
        return Registry.register(Registry.BLOCK, new Identifier(BlueGoldMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem (String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(BlueGoldMod.MOD_ID, name)
        , new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks(){
        BlueGoldMod.LOGGER.info("Registering ModBlocks for "+ BlueGoldMod.MOD_ID);
    }
}
