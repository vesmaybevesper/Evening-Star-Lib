package dev.vesper.eveningstarlib.mixin;
//? fabric {
import dev.vesper.eveningstarlib.fabric.events.LevelEvents;
//? <1.21.9{
/*import net.minecraft.client.gui.screens.ReceivingLevelScreen;
*///?}
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//?}
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
@Mixin(Minecraft.class)
public class MinecraftMixin {
    //? fabric {
    @Shadow
    @Nullable
    public ClientLevel level;
//? >=1.21.9 {
    @Inject(method = "setLevel", at = @At("HEAD"))
    private void onUnload(ClientLevel clientLevel, CallbackInfo ci){
        if (this.level != null) new LevelEvents.Unload(this.level).sendEvent();
    }
    //?}
    //? <1.21.9 {
/*@Inject(method = "setLevel", at = @At("HEAD"))
private void onUnload(ClientLevel clientLevel, ReceivingLevelScreen.Reason reason, CallbackInfo ci){
    if (this.level != null) new LevelEvents.Unload(this.level).sendEvent();
}
    *///?}
//? 1.21.11 {
    /*@Inject(method = "disconnect(Lnet/minecraft/client/gui/screens/Screen;ZZ)V", at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/client/Minecraft;level:Lnet/minecraft/client/multiplayer/ClientLevel;",
            ordinal = 0,
            shift = At.Shift.AFTER
    ))
    private void onDisconnect(Screen screen, boolean bl, boolean bl2, CallbackInfo ci) {
        if (this.level != null) {
            new LevelEvents.Unload(this.level).sendEvent();
        }
    }
    *///?}
    //? <1.21.11 && >=1.21.6 {
@Inject(method = "disconnect", at = @At(
        value = "FIELD",
        target = "Lnet/minecraft/client/Minecraft;level:Lnet/minecraft/client/multiplayer/ClientLevel;",
        ordinal = 0,
        shift = At.Shift.AFTER
))
private void onDisconnect(Screen screen, boolean bl, CallbackInfo ci) {
    if (this.level != null) {
        new LevelEvents.Unload(this.level).sendEvent();
    }
}
    //?}

    //? <1.21.6 {
    /*@Inject(method = "disconnect(Lnet/minecraft/client/gui/screens/Screen;Z)V", at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/client/Minecraft;level:Lnet/minecraft/client/multiplayer/ClientLevel;",
            ordinal = 0,
            shift = At.Shift.AFTER
    ))
    private void onDisconnect(Screen screen, boolean bl, CallbackInfo ci) {
        if (this.level != null) {
            new LevelEvents.Unload(this.level).sendEvent();
        }
    }
    *///?}

    //?}
}
