package dev.vesper.eveningstarlib.mixin.polyphonic;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import dev.vesper.eveningstarlib.common.polyphonic.SoundTags;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LightningBolt.class)
@MixinEnvironment(type = MixinEnvironment.Env.MAIN)
public abstract class LightningBoltMixin extends Entity {

	public LightningBoltMixin(EntityType<?> type, Level level) {
		super(type, level);
	}

	@Unique
	private enum Distance {FAR, MED, CLOSE}

	@Definition(id = "playLocalSound", field = "Lnet/minecraft/world/level/Level;playLocalSound")
	@Definition(id = "level", field = "Lnet/minecraft/world/entity/LightningBolt;level()Lnet/minecraft/world/level/Level;")
	@Definition(id = "LIGHTNING_BOLT_THUNDER", field = "Lnet/minecraft/sounds/SoundEvents;LIGHTNING_BOLT_THUNDER:Lnet/minecraft/sounds/SoundEvent;")
	@Definition(id = "SoundEvents", field = "SoundEvents")
	@Expression("this.level().playLocalSound(?, ?, ?, SoundEvents.LIGHTNING_BOLT_THUNDER, ?, ?, ?, ?)")
	@Redirect(method = "tick", at = @At(value = "MIXINEXTRAS:EXPRESSION"))
	private void onTick(Level instance, double d, double e, double f, SoundEvent soundEvent, SoundSource soundSource, float g, float h, boolean bl){
		if (distanceType() == Distance.FAR) {
			instance.playLocalSound(d, e, f, SoundTags.LIGHTNING_STRIKE_FAR, soundSource, g, h, bl);
		} else if (distanceType() == Distance.MED) {
			instance.playLocalSound(d, e, f, SoundTags.LIGHTNING_STRIKE_MED, soundSource, g, h, bl);
		} else {
			instance.playLocalSound(d, e, f, SoundEvents.LIGHTNING_BOLT_THUNDER, soundSource, g, h, bl);
		}
	}

	@Unique
	private Distance distanceType(){
		// ok, this needs double-checking on my math lmfao
		int renderDistanceBlocks = Minecraft.getInstance().options.renderDistance().get() * 16;
		assert Minecraft.getInstance().player != null;
		Vec2 playerPos = new Vec2((float) Minecraft.getInstance().player.getX(), (float) Minecraft.getInstance().player.getY());
		Vec2 strikePos = new Vec2((float) this.getX(), (float) this.getY());
		float distFromPlayerX = Math.abs(playerPos.x) - Math.abs(strikePos.x);
		float distFromPlayerY = Math.abs(playerPos.y) - Math.abs(strikePos.y);
		float distX = Math.abs(distFromPlayerX) / renderDistanceBlocks;
		float distY = Math.abs(distFromPlayerY) / renderDistanceBlocks;
		if (distX >= (renderDistanceBlocks * .75) || distY >= (renderDistanceBlocks * .75)) {
			return Distance.FAR;
		} else if (distX >= (renderDistanceBlocks * .45) || distY >= (renderDistanceBlocks * .45)){
			return Distance.MED;
		} else {
			return Distance.CLOSE;
		}
	}
}
