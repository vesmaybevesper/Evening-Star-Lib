package dev.vesper.eveningstarlib.fabric;

//? fabric {
import dev.vesper.eveningstarlib.EveningStarLib;
import dev.vesper.eveningstarlib.common.Aurora.AuroraDefaultUniforms;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;

public class FabricClientEntrypoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EveningStarLib.LOG.info("Initializing {} Client", EveningStarLib.MOD_ID);

        AuroraDefaultUniforms.registerAll();

        WorldRenderEvents.BEFORE_ENTITIES.register(worldRenderContext -> {AuroraDefaultUniforms.updateAll();});
    }

}
//?}