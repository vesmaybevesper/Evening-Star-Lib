package dev.vesper.eveningstarlib.common.utilities;

import net.minecraft.client.Minecraft;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec2;

import java.util.Random;

public class PosUtils {

	/**
	 * Returns a random location at the edge of the game window
	 * @return Vec2
	 */
	public static Vec2 posAtRanScreenEdge(){
		// random switch between render along top/bottom and side
		if (RandomSource.create().nextBoolean()){
			// render along the top/ bottom
			float height = Minecraft.getInstance().getWindow().getHeight();
			float randomHeight;
			//pick top or bottom
			if (RandomSource.create().nextIntBetweenInclusive(0,1) == 1) {
				randomHeight = height;
			} else {
				randomHeight = 0;
			}
			float width = Minecraft.getInstance().getWindow().getWidth();
			float randomWidth = RandomSource.create().nextIntBetweenInclusive(0, (int) width);

			return new Vec2(randomWidth, randomHeight);
		} else {
			// render along the side
			float width = Minecraft.getInstance().getWindow().getWidth();
			float randomWidth;
			//pick side
			if (RandomSource.create().nextIntBetweenInclusive(0,1) == 1) {
				randomWidth = width;
			} else {
				randomWidth = 0;
			}
			float height = Minecraft.getInstance().getWindow().getHeight();
			float randomHeight = RandomSource.create().nextIntBetweenInclusive(0, (int) height);

			return new Vec2(randomWidth, randomHeight);

		}
	}

	/**
	 * A random offset. Returns a number between +/- range
	 * @param range The max +/- range of the offset
	 * @return double
	 */
	public static double offsetWithNegative(double range){
		Random random = new Random();
		return random.nextDouble(range + 1) - range;
	}

	/**
	 * A sized down random offset. Returns a random number between +/- (range / 10000)
	 * @param range A double 1000X the max range size
	 * @return double
	 */
	public static double particleOffset(double range){
		Random random = new Random();
		return (random.nextDouble(range + 1) - range) / 10000;
	}
}
