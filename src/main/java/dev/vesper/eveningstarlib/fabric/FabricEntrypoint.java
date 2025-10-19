package dev.vesper.eveningstarlib.fabric;

//? fabric {
import dev.vesper.eveningstarlib.EveningStarLib;
import dev.vesper.eveningstarlib.common.ESLPosUtils;
import net.fabricmc.api.ModInitializer;

public class FabricEntrypoint implements ModInitializer {

    @Override
    public void onInitialize() {
        EveningStarLib.init();
    }

}
//?}