package net.isomo.bluegoldmod.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {

    BLUE_GOLD(2, 905, 7.0F, 2.5F, 12, () -> {
        return Ingredient.ofItems(ModItems.BLUE_GOLD_INGOT);
    }),
    REINFORCED_BLUE_GOLD(4, 2561, 17.5F, 5.0F, 18, () -> {
        return Ingredient.ofItems(ModItems.REINFORCED_BLUE_GOLD_INGOT);
    }),
    REINFORCED_BLUE_GOLD_2(4, 2561, 21F, 5.0F, 18, () -> {
        return Ingredient.ofItems(ModItems.REINFORCED_BLUE_GOLD_INGOT);
    }),
    ARKHALITZ(0, 3561, 0.0F, 5.0F, 20, () -> {
        return Ingredient.ofItems(ModItems.REINFORCED_BLUE_GOLD_INGOT);
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
