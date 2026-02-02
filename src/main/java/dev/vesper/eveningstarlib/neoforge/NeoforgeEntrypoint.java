package dev.vesper.eveningstarlib.neoforge;

//? neoforge {
/*import dev.vesper.eveningstarlib.EveningStarLib;
import dev.vesper.eveningstarlib.common.Aurora.AuroraDefaultUniforms;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(EveningStarLib.MOD_ID)
public class NeoforgeEntrypoint {

    public NeoforgeEntrypoint() {
        EveningStarLib.init();
    }

    @EventBusSubscriber(modid = EveningStarLib.MOD_ID, value = Dist.CLIENT)
    public static class ClientEvents {
        @SubscribeEvent
        public static void onClientSetup(final FMLClientSetupEvent event) {
            EveningStarLib.LOG.info("Initializing {} Client", EveningStarLib.MOD_ID);

            AuroraDefaultUniforms.registerAll();
        }

        @SubscribeEvent
        public static void onRenderLevelStage(RenderLevelStageEvent.AfterWeather event) {
            AuroraDefaultUniforms.updateAll();
        }
    }
}
*///?}