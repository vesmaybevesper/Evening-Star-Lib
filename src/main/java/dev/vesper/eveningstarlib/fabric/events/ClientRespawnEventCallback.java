package dev.vesper.eveningstarlib.fabric.events;
//? fabric {
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.Connection;

public interface ClientRespawnEventCallback {
    Event<ClientRespawnEventCallback> EVENT = EventFactory.createArrayBacked(ClientRespawnEventCallback.class, callbacks -> (pc, oldPlayer, newPlayer, networkManager) ->{
        for (ClientRespawnEventCallback e : callbacks)
            e.onRespawn(pc, oldPlayer, newPlayer, networkManager);
    });

    void onRespawn(MultiPlayerGameMode gameMode, LocalPlayer oldPlayer, LocalPlayer newPlayer, Connection clientConnection);
}
//?}