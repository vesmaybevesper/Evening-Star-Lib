package vesper.esl;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.random.Random;

@Environment(EnvType.CLIENT)
public class ESLPosUtils {

    public static Vec2f posAtRanScreenEdge(){
        // random switch between render along top/bottom and side
        if (Random.create().nextBoolean()){
            // render along the top/ bottom
            float height = MinecraftClient.getInstance().getWindow().getHeight();
            float randomHeight;
            //pick top or bottom
            if (Random.create().nextBetween(0,1) == 1) {
                randomHeight = height;
            } else {
                randomHeight = 0;
            }
            float width = MinecraftClient.getInstance().getWindow().getWidth();
            float randomWidth = Random.create().nextBetween(0, (int) width);

            return new Vec2f(randomWidth, randomHeight);
        } else {
            // render along the side
            float width = MinecraftClient.getInstance().getWindow().getWidth();
            float randomWidth;
            //pick side
            if (Random.create().nextBetween(0,1) == 1) {
                randomWidth = width;
            } else {
                randomWidth = 0;
            }
            float height = MinecraftClient.getInstance().getWindow().getHeight();
            float randomHeight = Random.create().nextBetween(0, (int) height);

            return new Vec2f(randomWidth, randomHeight);

        }
    }
}
