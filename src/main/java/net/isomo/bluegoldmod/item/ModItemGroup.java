package net.isomo.bluegoldmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.isomo.bluegoldmod.BlueGoldMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup BLUEGOLD = FabricItemGroupBuilder.build(new Identifier(BlueGoldMod.MOD_ID,"blue_gold"),
            ()-> new ItemStack(ModItems.BLUE_GOLD_INGOT));
}
