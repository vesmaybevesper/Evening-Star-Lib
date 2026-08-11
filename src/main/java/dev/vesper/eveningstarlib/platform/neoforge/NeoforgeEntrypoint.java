package dev.vesper.eveningstarlib.platform.neoforge;

//? neoforge {

/*import dev.vesper.eveningstarlib.EveningStarLib;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;

//? >=26.1.2{
/^import dev.vesper.eveningstarlib.common.aurora.AuroraDefaultUniforms;
^///?}

@Mod(EveningStarLib.MOD_ID)
public class NeoforgeEntrypoint {

	public NeoforgeEntrypoint() {
		EveningStarLib.onInitialize();
	}

	//? >=26.1.2{
	/^@EventBusSubscriber(modid = EveningStarLib.MOD_ID, value = Dist.CLIENT)
	public static class ClientEvents {
		@SubscribeEvent
		public static void onClientSetup(final FMLClientSetupEvent event) {
			EveningStarLib.onInitialize();
			// AuroraDefaultUniforms.registerAll();
		}

		// I'm 45% sure this is the wrong event and that it should happen slightly sooner
        @SubscribeEvent
		public static void onRenderLevelStage(RenderLevelStageEvent.AfterWeather event) {
			//AuroraDefaultUniforms.updateAll();
		}
	}
	^///?}
}
*///?}
