package dev.vesper.eveningstarlib.mixin.events;

//? fabric {
import com.llamalad7.mixinextras.sugar.Local;
import dev.vesper.eveningstarlib.platform.fabric.events.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.Map;
//?}
import org.spongepowered.asm.mixin.Mixin;
import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import net.minecraft.server.MinecraftServer;

@Mixin(MinecraftServer.class)
@MixinEnvironment(type = MixinEnvironment.Env.MAIN)
public class MinecraftServerMixin {
	//? fabric {
	@Shadow
	@Final
	private Map<ResourceKey<Level>, ServerLevel> levels;

	@Inject(method = "createLevels", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/ServerLevelData;isInitialized()Z"))
	private void onLoadOverworld(CallbackInfo ci){
		new LevelEvents.Load(this.levels.get(Level.OVERWORLD)).sendEvent();
	}

	@Inject(method = "createLevels", at = @At(
			value = "INVOKE",
			target = "Ljava/util/Map;put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
			ordinal = 1,
			shift = At.Shift.AFTER
	))
	private void onLoadWorld(CallbackInfo ci, @Local/*? <=1.21.11{ *//*(index = 18) *//*?} >=26.1.2{ */(index = 15) /*?}*/ ResourceKey<Level> dimension) {
		new LevelEvents.Load(levels.get(dimension)).sendEvent();
	}

	@Inject(method = "stopServer", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;close()V"))
	private void onStopServer(CallbackInfo ci, @Local(index = 2) ServerLevel level) {
		new LevelEvents.Unload(level).sendEvent();
	}
//?}
}
