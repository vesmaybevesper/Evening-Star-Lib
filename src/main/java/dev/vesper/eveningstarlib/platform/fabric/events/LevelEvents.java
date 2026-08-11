package dev.vesper.eveningstarlib.platform.fabric.events;

//? fabric{

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.NotNull;

public abstract class LevelEvents {
	private final LevelAccessor level;

	private LevelEvents(LevelAccessor level){
		this.level = level;
	}

	public LevelAccessor getLevel() {
		return level;
	}

	public static class Load extends LevelEvents{
		public static final Event<Callback> LOAD = EventFactory.createArrayBacked(Callback.class, callbacks -> event -> {
			for (Callback callback : callbacks)
				callback.onLoad(event);
		});

		public Load(LevelAccessor level) {
			super(level);
		}

		public void sendEvent(){
			LOAD.invoker().onLoad(this);
		}

		public interface Callback{
			void onLoad(Load event);
		}
	}

	public static class Unload extends LevelEvents{
		public static final Event<Callback> UNLOAD = EventFactory.createArrayBacked(Callback.class, callbacks -> event -> {
			for (Callback callback : callbacks)
				callback.onUnload(event);
		});

		public Unload(LevelAccessor level) {
			super(level);
		}

		public void sendEvent() {
			UNLOAD.invoker().onUnload(this);
		}

		public interface Callback{
			void onUnload(Unload event);
		}
	}
}
//?}
