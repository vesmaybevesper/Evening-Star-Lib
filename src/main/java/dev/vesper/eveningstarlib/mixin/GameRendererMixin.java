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
	public void renderLevel(DeltaTracker deltaTracker, CallbackInfo ci) {
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
