package net.isomo.isomosmod;

import net.fabricmc.api.ModInitializer;
import net.isomo.isomosmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IsomosMod implements ModInitializer {
	public static final String MOD_ID = "isomosmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}
