package dev.vesper.eveningstarlib.mixin.events;

//? fabric {
import dev.vesper.eveningstarlib.platform.fabric.events.*;
//?}
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
//? >=26.2{
import net.minecraft.client.renderer.extract.LevelExtractor;
//?}
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.storage.WritableLevelData;
import org.spongepowered.asm.mixin.Mixin;
import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//? <=1.21.1{
/*import java.util.function.Supplier;
import net.minecraft.util.profiling.ProfilerFiller;
*///?}

@Mixin(ClientLevel.class)
@MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
public abstract class ClientLevelMixin extends Level {

	//? >1.21.1{
	protected ClientLevelMixin(WritableLevelData writableLevelData, ResourceKey<Level> resourceKey, RegistryAccess registryAccess, Holder<DimensionType> holder, boolean bl, boolean bl2, long l, int i) {
		super(writableLevelData, resourceKey, registryAccess, holder, bl, bl2, l, i);
	}
	//?} <=1.21.1{
	/*protected ClientLevelMixin(WritableLevelData p_270739_, ResourceKey<Level> p_270683_, RegistryAccess p_270200_, Holder<DimensionType> p_270240_, Supplier<ProfilerFiller> p_270692_, boolean p_270904_, boolean p_270470_, long p_270248_, int p_270466_) {
		super(p_270739_, p_270683_, p_270200_, p_270240_, p_270692_, p_270904_, p_270470_, p_270248_, p_270466_);
	}
	*///?}

	//? fabric {
//? 26.1.2 || 1.21.11{
    /*@Inject(method = "<init>", at = @At("TAIL"))
    private void onLoad(ClientPacketListener connection, ClientLevel.ClientLevelData levelData, ResourceKey dimension, Holder dimensionType, int serverChunkRadius, int serverSimulationDistance, LevelRenderer levelRenderer, boolean isDebug, long biomeZoomSeed, int seaLevel, CallbackInfo ci){
        new LevelEvents.Load(this).sendEvent();
    }
    *///?} >=26.2{
	@Inject(method = "<init>", at = @At("TAIL"))
	private void onLoad(ClientPacketListener connection, ClientLevel.ClientLevelData levelData, ResourceKey dimension, Holder dimensionType, int serverChunkRadius, int serverSimulationDistance, LevelExtractor levelExtractor, boolean isDebug, long biomeZoomSeed, int seaLevel, CallbackInfo ci){
		new LevelEvents.Load(this).sendEvent();
	}
	//?} <=1.21.1{
	/*@Inject(method = "<init>", at = @At("TAIL"))
	private void onLoad(ClientPacketListener clientPacketListener, ClientLevel.ClientLevelData clientLevelData, ResourceKey resourceKey, Holder holder, int i, int j, Supplier supplier, LevelRenderer levelRenderer, boolean bl, long l, CallbackInfo ci){
		new LevelEvents.Load(this).sendEvent();
	}
	*///?}

	//?}
}
