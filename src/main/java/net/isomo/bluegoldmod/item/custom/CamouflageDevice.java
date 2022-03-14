package net.isomo.bluegoldmod.item.custom;


import net.isomo.bluegoldmod.item.ModItems;
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
    public CamouflageDevice(Settings settings) {super(settings);}

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand){
        for(int i=0;i<=36;i++){
            Item item = player.getInventory().getStack(i).getItem();
            ItemStack stack = player.getInventory().getStack(i);
            if(item == ModItems.DEVICE_BATTERY){
                if (!player.getAbilities().creativeMode) {
                    stack.decrement(1);
                }
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 400,0,false,false));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200,1,false,false));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200,0,false,false));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 400,0,false,false));
                player.getStackInHand(hand).damage(1,player,p->p.sendToolBreakStatus(hand));
                player.playSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 0.6f, 1.0f);
                player.getItemCooldownManager().set(this, 1000);
                return TypedActionResult.success(player.getStackInHand(hand));
            }
        }
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
