package dev.vesper.eveningstarlib.mixin;

import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//? >=26.1.2{
import net.minecraft.client.DeltaTracker;
//?}

@Mixin(GameRenderer.class)
@MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
public class GameRendererMixin {

	//? >=26.1.2{
	@Inject(method = "renderLevel", at = @At("HEAD"))
	//~ if >=26.3 'DeltaTracker deltaTracker, CallbackInfo ci' -> 'CallbackInfo ci'
	public void renderLevel(CallbackInfo ci) {
		//RenderSystem.assertOnRenderThread();
		//AuroraUploader.uploadUniformsToCurrentProgram();
	}

	@Inject(method = "resetData", at = @At("RETURN"))
	private void afterResetData(CallbackInfo ci){
		//AuroraUploader.clearCache();
	}

	@Inject(method = "resize", at = @At("RETURN"))
	private void afterResize(CallbackInfo ci){
		//AuroraUploader.clearCache();
	}
	//?}
}
