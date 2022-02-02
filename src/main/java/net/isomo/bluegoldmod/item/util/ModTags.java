package net.isomo.bluegoldmod.item.util;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.isomo.bluegoldmod.BlueGoldMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        private static Tag.Identified<Block> createTag(String name){
            return TagFactory.BLOCK.create(new Identifier(BlueGoldMod.MOD_ID, name));
        }
        private static Tag.Identified<Block> createCommonTag(String name){
            return TagFactory.BLOCK.create(new Identifier("c", name));
        }

    }

    public static class Items{
        public static final Tag.Identified<Item> BLUE_GLASS = createCommonTag("blue_glass");
        public static final Tag.Identified<Item> IRON_HANDLE = createCommonTag("iron_handle");

        private static Tag.Identified<Item> createTag(String name){
            return TagFactory.ITEM.create(new Identifier(BlueGoldMod.MOD_ID, name));
        }
        private static Tag.Identified<Item> createCommonTag(String name){
            return TagFactory.ITEM.create(new Identifier("c", name));
        }
    }
}