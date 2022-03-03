package net.isomo.bluegoldmod.item;

import net.isomo.bluegoldmod.block.ModBlocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {
    BLUE_GOLD("blue_gold", 24, new int[]{2, 5, 7, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.BLUE_GOLD_INGOT);
    }),
    REINFORCED_BLUE_GOLD("reinforced_blue_gold", 45, new int[]{3, 7, 9, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 1.0F, () -> {
        return Ingredient.ofItems(ModItems.REINFORCED_BLUE_GOLD_INGOT);
    }),
    BLUE_GLASS("blue_glass", 15, new int[]{0, 0, 0, 1}, 5, SoundEvents.ITEM_SPYGLASS_USE, 1.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModBlocks.BLUE_GLASS);
    }),
    LEATHER_STRIPS("leather_strips", 15, new int[]{1, 0, 0, 0}, 5, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 1.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.LEATHER_STRIPS);
    });

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private ModArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy(repairIngredientSupplier);
    }

    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredientSupplier.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
