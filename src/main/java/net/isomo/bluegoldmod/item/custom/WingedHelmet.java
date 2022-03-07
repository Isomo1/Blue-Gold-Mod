package net.isomo.bluegoldmod.item.custom;

import net.isomo.bluegoldmod.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class WingedHelmet extends ArmorItem {
    public WingedHelmet(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasHelmetOn(player)) {
                   if(player.getInventory().getArmorStack(3).getItem() == ModItems.WINGED_HELMET && !player.isOnGround()){
                        player.setVelocity(player.getVelocity().x, 1, player.getVelocity().z);
                   }
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean hasHelmetOn(PlayerEntity player) {
        ItemStack helmet = player.getInventory().getArmorStack(3);
        return !helmet.isEmpty();
    }

}
