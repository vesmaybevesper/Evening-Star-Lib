package dev.vesper.eveningstarlib.mixin;

//? fabric {
import dev.vesper.eveningstarlib.fabric.events.LevelEvents;
//?}
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.storage.WritableLevelData;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(ClientLevel.class)
public abstract class ClientLevelMixin extends Level {
    //? 1.21.1 {
    /*protected ClientLevelMixin(WritableLevelData writableLevelData, ResourceKey<Level> resourceKey, RegistryAccess registryAccess, Holder<DimensionType> holder, Supplier<ProfilerFiller> supplier, boolean bl, boolean bl2, long l, int i) {
        super(writableLevelData, resourceKey, registryAccess, holder, supplier, bl, bl2, l, i);
    }
    *///?}

    //? >= 1.21.4 {
    protected ClientLevelMixin(WritableLevelData writableLevelData, ResourceKey<@NotNull Level> resourceKey, RegistryAccess registryAccess, Holder<@NotNull DimensionType> holder, boolean bl, boolean bl2, long l, int i) {
        super(writableLevelData, resourceKey, registryAccess, holder, bl, bl2, l, i);
    }
    //?}

    //? fabric {
    //? >= 1.21.4 {
    @Inject(method = "<init>", at = @At("TAIL"))
    private void onLoad(ClientPacketListener clientPacketListener, ClientLevel.ClientLevelData clientLevelData, ResourceKey<?> resourceKey, Holder<?> holder, int i, int j, LevelRenderer levelRenderer, boolean bl, long l, int k, CallbackInfo ci){
        new LevelEvents.Load(this).sendEvent();
    }
    //?}
    //? 1.21.1 {
    /*@Inject(method = "<init>", at = @At("TAIL"))
    private void onLoad(ClientPacketListener clientPacketListener, ClientLevel.ClientLevelData clientLevelData, ResourceKey resourceKey, Holder holder, int i, int j, Supplier supplier, LevelRenderer levelRenderer, boolean bl, long l, CallbackInfo ci){
        new LevelEvents.Load(this).sendEvent();
    }
    *///?}
    //?}
}
