package dev.vesper.eveningstarlib.fabric;

//? fabric {
/*import dev.vesper.eveningstarlib.EveningStarLib;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderEvents;

public class FabricClientEntrypoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EveningStarLib.LOG.info("Initializing {} Client", EveningStarLib.MOD_ID);

        // AuroraDefaultUniforms.registerAll();
        // Not sure if this is the right event, was BEFORE_ENTITIES before the FAPI changes. Just picked the one that felt most right needs testing
        // LevelRenderEvents.AFTER_TRANSLUCENT_FEATURES.register(worldRenderContext -> {AuroraDefaultUniforms.updateAll();});
    }

}
*///?}