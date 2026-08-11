package dev.vesper.eveningstarlib.mixin.events;

//? fabric {
import dev.vesper.eveningstarlib.platform.fabric.events.*;
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
import dev.kikugie.fletching_table.annotation.MixinEnvironment;

@Mixin(Minecraft.class)
@MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
public class MinecraftMixin {
	//? fabric {
	@Shadow
	@Nullable
	public ClientLevel level;

	@Inject(method = "setLevel", at = @At("HEAD"))
	//? >1.21.1{
	private void onUnload(ClientLevel clientLevel, CallbackInfo ci){
	//?}1.21.1{
	/*private void onUnload(ClientLevel clientLevel, ReceivingLevelScreen.Reason reason, CallbackInfo ci){
	*///?} 1.20.1{
	/*private void onUnload(ClientLevel clientLevel, CallbackInfo ci){
	*///?}
		if (this.level != null) new LevelEvents.Unload(this.level).sendEvent();
	}

	//? >1.21.1{
	@Inject(method = "disconnect(Lnet/minecraft/client/gui/screens/Screen;ZZ)V", at = @At(
			value = "FIELD",
			target = "Lnet/minecraft/client/Minecraft;level:Lnet/minecraft/client/multiplayer/ClientLevel;",
			ordinal = 0,
			shift = At.Shift.AFTER
	))
	//?} 1.21.1{
	/*@Inject(method = "disconnect(Lnet/minecraft/client/gui/screens/Screen;Z)V", at = @At(
			value = "FIELD",
			target = "Lnet/minecraft/client/Minecraft;level:Lnet/minecraft/client/multiplayer/ClientLevel;",
			ordinal = 0,
			shift = At.Shift.AFTER
	))
	*///?} 1.20.1{
	/*@Inject(method = "clearLevel(Lnet/minecraft/client/gui/screens/Screen;)V", at = @At(
			value = "FIELD",
			target = "Lnet/minecraft/client/Minecraft;level:Lnet/minecraft/client/multiplayer/ClientLevel;",
			ordinal = 0,
			shift = At.Shift.AFTER
	))
	*///?}

	//? >1.21.1{
	private void onDisconnect(Screen screen, boolean bl, boolean bl2, CallbackInfo ci) {
	//?} 1.21.1{
	/*private void onDisconnect(Screen screen, boolean bl, CallbackInfo ci) {
	*///?} 1.20.1{
	/*private void onDisconnect(Screen screen, CallbackInfo ci) {
	*///?}
		if (this.level != null) {
			new LevelEvents.Unload(this.level).sendEvent();
		}
	}


	//?}
}
