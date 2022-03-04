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

public class SafetyDevice extends Item {
    public SafetyDevice(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand){
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20,99999,false,false));
        player.playSound(SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK, 1.0f, 1.0f);
        player.getItemCooldownManager().set(this, 500);
        return TypedActionResult.success(player.getStackInHand(hand));
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(new TranslatableText("item.bluegoldmod.safety_device.tooltip.shift"));
        }else{
            tooltip.add(new TranslatableText("item.bluegoldmod.safety_device.tooltip"));
        }
    }


}