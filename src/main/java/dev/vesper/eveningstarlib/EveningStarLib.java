package dev.vesper.eveningstarlib;

import dev.vesper.eveningstarlib.platform.Platform;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//? fabric {
import dev.vesper.eveningstarlib.platform.fabric.FabricPlatform;
import net.fabricmc.loader.api.FabricLoader;
//?} neoforge {
/*import dev.vesper.eveningstarlib.platform.neoforge.NeoforgePlatform;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;
 *///?} forge {
/*import dev.vesper.eveningstarlib.platform.forge.ForgePlatform;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLEnvironment;
 *///?}

@SuppressWarnings("LoggingSimilarMessage")
public class EveningStarLib {

	public static final String MOD_ID = /*$ mod_id*/ "eveningstarlib";
	public static final String MOD_VERSION = /*$ mod_version*/ "1.3.0";
	public static final String MOD_FRIENDLY_NAME = /*$ mod_name*/ "Evening Star Lib";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final Platform PLATFORM = createPlatformInstance();

	public static void onInitialize() {
		LOGGER.info("Initializing {} on {}", MOD_ID, EveningStarLib.xplat().loader());
		LOGGER.debug("{}: { version: {}; friendly_name: {} }", MOD_ID, MOD_VERSION, MOD_FRIENDLY_NAME);
	}

	public static void onInitializeClient() {
		LOGGER.info("Initializing {} Client on {}", MOD_ID, EveningStarLib.xplat().loader());
		LOGGER.debug("{}: { version: {}; friendly_name: {} }", MOD_ID, MOD_VERSION, MOD_FRIENDLY_NAME);
	}

	static Platform xplat() {
		return PLATFORM;
	}

	private static Platform createPlatformInstance() {
		//? fabric {
		return new FabricPlatform();
		//?} neoforge {
		/*return new NeoforgePlatform();
		 *///?} forge {
		/*return new ForgePlatform();
		 *///?}
	}

	public static boolean isDevEnv(){
		//? fabric{
		return FabricLoader.getInstance().isDevelopmentEnvironment();
		//?} neoforge{
		/*return !FMLEnvironment. /^? >=1.21.11{^/ isProduction() /^?} 1.21.1{ ^//^production ^//^?}^/;
		 *///?} forge{
		/*return !FMLEnvironment.production;
		*///?}
	}

	public static boolean isModLoaded(String modId){
		//? fabric {
		return FabricLoader.getInstance().isModLoaded(modId);
		//?}
		//? neoforge {
		/*return ModList.get().isLoaded(modId);
		 *///?} forge {
		/*return ModList.get().isLoaded(modId);
		*///?}
	}
}
