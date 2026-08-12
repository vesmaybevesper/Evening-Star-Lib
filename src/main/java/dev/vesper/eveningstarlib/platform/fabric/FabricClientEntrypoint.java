package dev.vesper.eveningstarlib.platform.fabric;

//? fabric {

import dev.vesper.eveningstarlib.EveningStarLib;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.Minecraft;

//? >=26.2{
import net.minecraft.client.PreferredGraphicsApi;
import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderEvents;
//?}
//? >=26.1.2{
import dev.vesper.eveningstarlib.common.aurora.AuroraDefaultUniforms;
//?}

@Entrypoint("client")
public class FabricClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		EveningStarLib.onInitializeClient();
		//? >=26.2{

         //?}
        }
	}
//?}

//if (Minecraft.getInstance().options.preferredGraphicsBackend().equals(PreferredGraphicsApi.VULKAN)) {
//		AuroraDefaultUniforms.registerAll();
////Not sure if this is the right event, was BEFORE_ENTITIES before the FAPI changes. Just picked the one that felt most right needs testing
//			LevelRenderEvents.AFTER_TRANSLUCENT_FEATURES.register(worldRenderContext -> {
//		AuroraDefaultUniforms.updateAll();
//	        });
//					}
