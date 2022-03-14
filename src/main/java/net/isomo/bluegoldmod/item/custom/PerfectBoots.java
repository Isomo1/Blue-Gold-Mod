package net.isomo.bluegoldmod.item.custom;

import net.isomo.bluegoldmod.item.ModItems;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PerfectBoots extends ArmorItem {
    public PerfectBoots(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(new TranslatableText("item.bluegoldmod.perfect_boots.tooltip.shift"));
        }else{
            tooltip.add(new TranslatableText("item.bluegoldmod.perfect_boots.tooltip"));
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasBootsOn(player)) {
                    evaluateEffect(player);
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateEffect(PlayerEntity player) {
        if(hasCorrectArmorOn(player)) {
            player.fallDistance = 0;
        }
    }

    private boolean hasBootsOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        return !boots.isEmpty();
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return !super.canRepair(stack, ingredient);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return !super.isEnchantable(stack);
    }

    private boolean hasCorrectArmorOn(PlayerEntity player) {
        if (player.getInventory().getArmorStack(0).getItem()==ModItems.PERFECT_BOOTS) {
            return true;
        }else{
            return false;
        }
    }
}
