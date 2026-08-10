package dev.vesper.eveningstarlilb.platform.fabric;

//? fabric {

import dev.vesper.eveningstarlilb.EveningStarLib;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ModInitializer;

@Entrypoint("main")
public class FabricEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		EveningStarLib.onInitialize();
	}
}
//?}
