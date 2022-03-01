package net.isomo.bluegoldmod.item.custom;


import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
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
        player.setVelocity(player.getVelocity().x, 2, player.getVelocity().z);
        player.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE, 1.0f, 1.0f);
        player.getItemCooldownManager().set(this, 90);
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
