package net.isomo.bluegoldmod.item.custom;


import net.isomo.bluegoldmod.item.ModItems;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PropulsionDevice extends Item {
    public PropulsionDevice(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand){
        for(int i=0;i<=36;i++){
            Item item = player.getInventory().getStack(i).getItem();
            ItemStack stack = player.getInventory().getStack(i);
            if(item == ModItems.DEVICE_BATTERY){
                if (!player.getAbilities().creativeMode) {
                    stack.decrement(1);
                }
                player.setVelocity(player.getVelocity().x, 3, player.getVelocity().z);
                player.getStackInHand(hand).damage(1,player,p->p.sendToolBreakStatus(hand));
                player.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE, 1.0f, 1.0f);
                player.getItemCooldownManager().set(this, 100);
                return TypedActionResult.success(player.getStackInHand(hand));
            }
        }
        return TypedActionResult.success(player.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(new TranslatableText("item.bluegoldmod.propulsion_device.tooltip.shift"));
        }else{
            tooltip.add(new TranslatableText("item.bluegoldmod.propulsion_device.tooltip"));
        }
    }
}
