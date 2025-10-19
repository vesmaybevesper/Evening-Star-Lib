package dev.vesper.eveningstarlib.fabric;

//? fabric {
import dev.vesper.eveningstarlib.EveningStarLib;
import net.fabricmc.api.ClientModInitializer;

public class FabricClientEntrypoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EveningStarLib.LOG.info("Initializing {} Client", EveningStarLib.MOD_ID);
    }

}
//?}