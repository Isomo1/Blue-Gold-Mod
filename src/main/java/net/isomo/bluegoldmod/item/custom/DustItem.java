package net.isomo.bluegoldmod.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DustItem extends Item {
    public DustItem(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(!Screen.hasShiftDown()){
            tooltip.add(new TranslatableText("item.bluegoldmod.dustitem.tooltip"));
        }else{
            tooltip.add(new TranslatableText("item.bluegoldmod.dustitem.tooltip.shift"));
        }
    }
}
