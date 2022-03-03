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

    public static final Block BLUE_GOLD_BLOCK = registerBlock("blue_gold_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6.0f).requiresTool().luminance(8)), ModItemGroup.BLUEGOLD);

    public static final Block REINFORCED_BLUE_GOLD_BLOCK = registerBlock("reinforced_blue_gold_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(7.0f).requiresTool().luminance(12)), ModItemGroup.BLUEGOLD);

    public static final Block BLUE_GLASS = registerBlock("blue_glass",
            new Block(FabricBlockSettings.of(Material.GLASS).strength(1.0f).requiresTool().luminance(5)), ModItemGroup.BLUEGOLD);

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
