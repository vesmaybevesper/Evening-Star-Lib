package dev.vesper.eveningstarlib.neoforge;

//? neoforge {
/*import dev.vesper.eveningstarlib.ModTemplate;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;


@Mod(ModTemplate.MOD_ID)
@EventBusSubscriber // sample_content
public class NeoforgeEntrypoint {

    public NeoforgeEntrypoint() {
        ModTemplate.init();
    }


    @EventBusSubscriber(modid = ModTemplate.MOD_ID, value = Dist.CLIENT)
    public static class ClientEvents {
        @SubscribeEvent
        public static void onClientSetup(final FMLClientSetupEvent event) {
            ModTemplate.LOG.info("Initializing {} Client", ModTemplate.MOD_ID);
        }
    }

}
*///?}