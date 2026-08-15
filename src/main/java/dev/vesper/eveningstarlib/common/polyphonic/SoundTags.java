package dev.vesper.eveningstarlib.common.polyphonic;

import dev.vesper.eveningstarlib.EveningStarLib;
import dev.vesper.eveningstarlib.common.polyphonic.api.SoundRegisterer;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Experimental
@ApiStatus.Internal
public class SoundTags {
	public static final SoundEvent LIGHTNING_STRIKE_FAR = register("weather.lightning.far");
	public static final SoundEvent LIGHTNING_STRIKE_MED = register("weather.lightning.med");

	public static void bootstrap(){}

	private static SoundEvent register(String id) {
		return SoundRegisterer.registerTag(EveningStarLib.MOD_ID, id);
	}
}
