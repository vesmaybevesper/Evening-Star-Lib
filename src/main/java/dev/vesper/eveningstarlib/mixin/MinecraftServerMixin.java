package dev.vesper.eveningstarlib.mixin;
//? fabric {
import com.llamalad7.mixinextras.sugar.Local;
import dev.vesper.eveningstarlib.fabric.events.LevelEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.progress.ChunkProgressListener;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.Map;
//? }
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.server.MinecraftServer;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
//? fabric {
    @Shadow
    @Final
    private Map<ResourceKey<Level>, ServerLevel> levels;

    @Inject(method = "createLevels", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/ServerLevelData;isInitialized()Z"))
    private void onLoadOverworld(ChunkProgressListener chunkProgressListener, CallbackInfo ci){
        new LevelEvents.Load(this.levels.get(Level.OVERWORLD)).sendEvent();
    }

    @Inject(method = "createLevels", at = @At(
            value = "INVOKE",
            target = "Ljava/util/Map;put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
            ordinal = 1,
            shift = At.Shift.AFTER
    ))
    private void onLoadWorld(ChunkProgressListener chunkProgressListener, CallbackInfo ci, @Local(index = 18) ResourceKey<Level> key) {
        new LevelEvents.Load(levels.get(key)).sendEvent();
    }

    @Inject(method = "stopServer", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;close()V"))
    private void onStopServer(CallbackInfo ci, @Local(index = 2) ServerLevel serverLevel) {
        new LevelEvents.Unload(serverLevel).sendEvent();
    }
//? }
}
