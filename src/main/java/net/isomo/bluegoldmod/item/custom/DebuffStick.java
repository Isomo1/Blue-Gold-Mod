package net.isomo.bluegoldmod.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DebuffStick extends SwordItem {
    public DebuffStick(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return !super.isEnchantable(stack);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return !super.canRepair(stack, ingredient);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,200,0,true,true),attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,200,7,true,true),attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS,200,0,true,true),attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,200,2,true,true),attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,200,0,true,true),attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE,200,3,true,true),attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER,200,99,true,true),attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON,200,99,true,true),attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,200,99,true,true),attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE,20,0,true,true),attacker);
        stack.damage(1,attacker,p->p.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(new TranslatableText("item.bluegoldmod.debuff_stick.tooltip.shift"));
        }else{
            tooltip.add(new TranslatableText("item.bluegoldmod.debuff_stick.tooltip"));
        }
    }
}
