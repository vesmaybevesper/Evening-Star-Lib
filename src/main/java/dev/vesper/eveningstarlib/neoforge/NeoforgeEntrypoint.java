package dev.vesper.eveningstarlib.neoforge;

//? neoforge {
/*import dev.vesper.eveningstarlib.EveningStarLib;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;


@Mod(EveningStarLib.MOD_ID)
@EventBusSubscriber // sample_content
public class NeoforgeEntrypoint {

    public NeoforgeEntrypoint() {
        EveningStarLib.init();
    }


    @EventBusSubscriber(modid = EveningStarLib.MOD_ID, value = Dist.CLIENT)
    public static class ClientEvents {
        @SubscribeEvent
        public static void onClientSetup(final FMLClientSetupEvent event) {
            EveningStarLib.LOG.info("Initializing {} Client", EveningStarLib.MOD_ID);
        }
    }

}
*///?}