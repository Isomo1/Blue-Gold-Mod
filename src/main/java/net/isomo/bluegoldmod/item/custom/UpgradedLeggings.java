package net.isomo.bluegoldmod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.isomo.bluegoldmod.item.ModArmorMaterial;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class UpgradedLeggings extends ArmorItem {
    private static final Map<ArmorMaterial, StatusEffect> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffect>())
                    .put(ModArmorMaterial.REINFORCED_BLUE_GOLD, StatusEffects.JUMP_BOOST).build();

    public UpgradedLeggings(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasLeggingsOn(player)) {
                    evaluateArmorEffects(player);
                }else{
                    player.removeStatusEffect(StatusEffects.JUMP_BOOST);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(new TranslatableText("item.bluegoldmod.upgraded_leggings.tooltip.shift"));
        }else{
            tooltip.add(new TranslatableText("item.bluegoldmod.upgraded_leggings.tooltip"));
        }
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffect> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffect mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffect mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect);

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect, 400,2,false,false));
        }
    }

    private boolean hasLeggingsOn(PlayerEntity player) {
        ItemStack leggings = player.getInventory().getArmorStack(1);
        return !leggings.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        return leggings.getMaterial() == material;
    }
}
