package dev.vesper.eveningstarlib.common;

import net.minecraft.client.Minecraft;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec2;

public class ESLPosUtils {
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
}
