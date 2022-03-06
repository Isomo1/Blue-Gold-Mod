package net.isomo.bluegoldmod.util;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.isomo.bluegoldmod.item.ModItems;

public class ModLootTableModifiers {
    private static final Identifier LAPIS_ORE_ID
            = new Identifier("minecraft", "blocks/lapis_ore");

    private static final Identifier DEEPSLATE_LAPIS_ORE_ID
            = new Identifier("minecraft", "blocks/deepslate_lapis_ore");


    public static void modifyLootTables() {
        LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
            if(LAPIS_ORE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.75f))
                        .with(ItemEntry.builder(ModItems.RADIANT_DUST))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }
            if(DEEPSLATE_LAPIS_ORE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.75f))
                        .with(ItemEntry.builder(ModItems.RADIANT_DUST))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }

        }));
    }
}