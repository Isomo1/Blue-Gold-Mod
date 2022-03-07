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

public class BlessedAmulet extends Item {
    public BlessedAmulet(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand){
        if(player.hasStatusEffect(StatusEffects.BLINDNESS)){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 200,0,false,false));
            player.removeStatusEffect(StatusEffects.BLINDNESS);
        } else if(player.hasStatusEffect(StatusEffects.WEAKNESS)){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200,0,false,false));
            player.removeStatusEffect(StatusEffects.WEAKNESS);
        } else if(player.hasStatusEffect(StatusEffects.NAUSEA)){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 200,0,false,false));
            player.removeStatusEffect(StatusEffects.NAUSEA);
        } else if(player.hasStatusEffect(StatusEffects.WITHER)){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200,0,false,false));
            player.removeStatusEffect(StatusEffects.WITHER);
        } else if(player.hasStatusEffect(StatusEffects.INSTANT_DAMAGE)){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 200,0,false,false));
            player.removeStatusEffect(StatusEffects.INSTANT_DAMAGE);
        } else if(player.hasStatusEffect(StatusEffects.SLOWNESS)){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200,0,false,false));
            player.removeStatusEffect(StatusEffects.SLOWNESS);
        } else if(player.hasStatusEffect(StatusEffects.LEVITATION)){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200,0,false,false));
            player.removeStatusEffect(StatusEffects.LEVITATION);
        } else if(player.hasStatusEffect(StatusEffects.HUNGER)){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 200,0,false,false));
            player.removeStatusEffect(StatusEffects.HUNGER);
        } else if(player.hasStatusEffect(StatusEffects.POISON)){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200,0,false,false));
            player.removeStatusEffect(StatusEffects.POISON);
        } else if(player.hasStatusEffect(StatusEffects.MINING_FATIGUE)){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 200,0,false,false));
            player.removeStatusEffect(StatusEffects.MINING_FATIGUE);
        }
        player.playSound(SoundEvents.BLOCK_GLASS_BREAK, 1.0f, 0.7f);
        player.getStackInHand(hand).damage(1,player,p->p.sendToolBreakStatus(hand));
        return TypedActionResult.success(player.getStackInHand(hand));
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return !super.canRepair(stack, ingredient);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(new TranslatableText("item.bluegoldmod.blessed_amulet.tooltip.shift"));
        }else{
            tooltip.add(new TranslatableText("item.bluegoldmod.blessed_amulet.tooltip"));
        }
    }
}
