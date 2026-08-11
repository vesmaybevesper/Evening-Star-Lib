package dev.vesper.eveningstarlib.mixin.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.Connection;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import dev.kikugie.fletching_table.annotation.MixinEnvironment;

//? >=1.21.1{
import net.minecraft.client.multiplayer.ClientCommonPacketListenerImpl;
import net.minecraft.client.multiplayer.CommonListenerCookie;
//?}

//? fabric{
import dev.vesper.eveningstarlib.platform.fabric.events.ClientRespawnEventCallback;
//?}

//? !forge{
import com.llamalad7.mixinextras.sugar.Local;
//?}

@Mixin(net.minecraft.client.multiplayer.ClientPacketListener.class)
@MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
public abstract class ClientPacketListener /*? >=1.21.1 {*/ extends ClientCommonPacketListenerImpl /*?}*/ {

	//? >=1.21.1{
	protected ClientPacketListener(Minecraft minecraft, Connection connection, CommonListenerCookie commonListenerCookie) {
		super(minecraft, connection, commonListenerCookie);
	}

	//? fabric {
	@ModifyArg(method = "handleRespawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ClientLevel;addEntity(Lnet/minecraft/world/entity/Entity;)V"))
	private Entity onClientPlayerRespawn(Entity entity, @Local(ordinal = 0) LocalPlayer localPlayer){
		LocalPlayer player = (LocalPlayer) entity;
		ClientRespawnEventCallback.EVENT.invoker().onRespawn(this.minecraft.gameMode, localPlayer, player, this.connection);
		return entity;
	}
    //?}
	//?}
}

