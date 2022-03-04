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

public class CamouflageDevice extends Item {
    public CamouflageDevice(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand){
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 600,0,false,false));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200,1,false,false));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200,0,false,false));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 600,0,false,false));
        player.playSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 1.0f, 1.0f);
        player.getItemCooldownManager().set(this, 1200);
        return TypedActionResult.success(player.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(new TranslatableText("item.bluegoldmod.camouflage_device.tooltip.shift"));
        }else{
            tooltip.add(new TranslatableText("item.bluegoldmod.camouflage_device.tooltip"));
        }
    }
}
