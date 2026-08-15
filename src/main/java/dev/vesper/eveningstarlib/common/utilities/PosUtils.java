package dev.vesper.eveningstarlib.common.utilities;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

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
	 * A sized down random offset intended for use with particle positions. Returns a random number between +/- (range / 10000)
	 * @param range A double 1000X the max range size
	 * @return double
	 */
	public static double particleOffset(double range){
		Random random = new Random();
		return (random.nextDouble(range + 1) - range) / 10000;
	}

	/**
	 * Calculation to check the distance between two points without height. Returns the distance as a positive number.
	 * @param fromPos The point we are checking the distance from
	 * @param toPos The point we are checking the distance to
	 * @return Vec2
	 */
	public static Vec2 getDistance(Vec2 fromPos, Vec2 toPos){
		float fromPosX = fromPos.x;
		float fromPosY = fromPos.y;
		float toPosX = toPos.x;
		float toPosY = toPos.y;
		float distanceX = Math.abs(fromPos.x) - Math.abs(toPos.x);
		float distanceY = Math.abs(fromPos.y) - Math.abs(toPos.y);
		distanceX = Math.abs(distanceX);
		distanceY = Math.abs(distanceY);
		return new Vec2(distanceX, distanceY);
	}

	/**
	 * Calculation to check the distance between two points. Returns the distance as a positive number.
	 * @param fromPos The point we are checking the distance from
	 * @param toPos The point we are checking the distance to
	 * @return Vec3
	 */
	public static Vec3 getDistance(Vec3 fromPos, Vec3 toPos){
		double distanceX = Math.abs(fromPos.x) - Math.abs(toPos.x);
		double distanceY = Math.abs(fromPos.y) - Math.abs(toPos.y);
		double distanceZ = Math.abs(fromPos.z) - Math.abs(toPos.z);
		distanceX = Math.abs(distanceX);
		distanceY = Math.abs(distanceY);
		distanceZ = Math.abs(distanceZ);
		return new Vec3(distanceX, distanceY, distanceZ);
	}
}
