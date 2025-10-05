package dev.vesper.eveningstarlib.fabric;

//? fabric {
import dev.vesper.eveningstarlib.ModTemplate;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents; // sample_content
import net.minecraft.server.level.ServerPlayer; // sample_content

public class FabricEntrypoint implements ModInitializer {

    @Override
    public void onInitialize() {
        ModTemplate.init();
    }

}
//?}