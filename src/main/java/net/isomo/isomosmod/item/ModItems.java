package net.isomo.isomosmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.isomo.isomosmod.IsomosMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item BLUE_GOLD_INGOT = registerItem("blue_gold_ingot",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item BLUE_GOLD_NUGGET = registerItem("blue_gold_nugget",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item RAW_BLUE_GOLD = registerItem("raw_blue_gold",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(IsomosMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        IsomosMod.LOGGER.info("Registering Mod Items for "+IsomosMod.MOD_ID);
    }
}
