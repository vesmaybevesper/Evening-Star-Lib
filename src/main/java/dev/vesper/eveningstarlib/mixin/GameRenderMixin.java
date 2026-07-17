package dev.vesper.eveningstarlib.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRenderMixin {

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
}
