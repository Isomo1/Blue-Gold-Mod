package net.isomo.bluegoldmod;

import net.fabricmc.api.ModInitializer;
import net.isomo.bluegoldmod.block.ModBlocks;
import net.isomo.bluegoldmod.item.ModItems;
import net.isomo.bluegoldmod.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlueGoldMod implements ModInitializer {
	public static final String MOD_ID = "bluegoldmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModLootTableModifiers.modifyLootTables();
	}
}
