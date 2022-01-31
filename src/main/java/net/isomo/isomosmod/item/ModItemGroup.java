package net.isomo.isomosmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.isomo.isomosmod.IsomosMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup BLUEGOLD = FabricItemGroupBuilder.build(new Identifier(IsomosMod.MOD_ID,"blue_gold"),
            ()-> new ItemStack(ModItems.BLUE_GOLD_INGOT));
}
