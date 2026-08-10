package dev.vesper.eveningstarlib.fabric;

//? fabric {
import dev.vesper.eveningstarlib.EveningStarLib;
import net.fabricmc.api.ClientModInitializer;

public class FabricClientEntrypoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EveningStarLib.LOG.info("Initializing {} Client", EveningStarLib.MOD_ID);

        //? >=26.2{
        /*if (Minecraft.getInstance().options.preferredGraphicsBackend().equals()) {
         AuroraDefaultUniforms.registerAll();
         //Not sure if this is the right event, was BEFORE_ENTITIES before the FAPI changes. Just picked the one that felt most right needs testing
         LevelRenderEvents.AFTER_TRANSLUCENT_FEATURES.register(worldRenderContext -> {AuroraDefaultUniforms.updateAll();});
        }*/
        //?}
    }

}
//?}