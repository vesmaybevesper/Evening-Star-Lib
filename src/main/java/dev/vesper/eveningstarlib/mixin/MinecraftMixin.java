package dev.vesper.eveningstarlib.mixin;
//? fabric {
import dev.vesper.eveningstarlib.fabric.events.LevelEvents;
import net.minecraft.client.gui.screens.ReceivingLevelScreen;
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

    @Inject(method = "setLevel", at = @At("HEAD"))
    private void onUnload(ClientLevel clientLevel, ReceivingLevelScreen.Reason reason, CallbackInfo ci){
        if (this.level != null) new LevelEvents.Unload(this.level).sendEvent();
    }

    @Inject(method = "disconnect(Lnet/minecraft/client/gui/screens/Screen;Z)V", at = @At(
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
}
