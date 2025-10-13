package dev.vesper.eveningstarlib.mixin;


import com.llamalad7.mixinextras.sugar.Local;
//? fabric {
import dev.vesper.eveningstarlib.fabric.events.ClientRespawnEventCallback;
//?}
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientCommonPacketListenerImpl;
import net.minecraft.client.multiplayer.CommonListenerCookie;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.Connection;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(net.minecraft.client.multiplayer.ClientPacketListener.class)
public abstract class ClientPacketListener extends ClientCommonPacketListenerImpl {

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
}

