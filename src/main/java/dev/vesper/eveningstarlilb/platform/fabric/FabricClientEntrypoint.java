package dev.vesper.eveningstarlilb.platform.fabric;

//? fabric {

import dev.vesper.eveningstarlilb.EveningStarLib;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ClientModInitializer;

@Entrypoint("client")
public class FabricClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		EveningStarLib.onInitializeClient();
	}

}
//?}
