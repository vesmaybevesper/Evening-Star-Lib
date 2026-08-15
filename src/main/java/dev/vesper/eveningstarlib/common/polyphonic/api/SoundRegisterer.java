package dev.vesper.eveningstarlib.common.polyphonic.api;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class SoundRegisterer {

	public static SoundEvent registerTag(final String modid, final String id) {
		//? >=1.21.1{
		return register(Identifier.fromNamespaceAndPath(modid , id));
		//?} 1.20.1{
		/*return register(Identifier.tryBuild(modid, id));
		*///?}
	}

	private static SoundEvent register(final Identifier id) {
		return register(id, id);
	}

	private static SoundEvent register(final Identifier id, final Identifier soundId) {
		return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(soundId));
	}
}
