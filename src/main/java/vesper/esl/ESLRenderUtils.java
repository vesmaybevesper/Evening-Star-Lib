package vesper.esl;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.util.math.Vec3d;


@Environment(EnvType.CLIENT)
public class ESLRenderUtils {
    public static Camera getCamera(){return MinecraftClient.getInstance().gameRenderer.getCamera();}

    public static Vec3d getCameraPos(){
        Camera camera = getCamera();
        return camera.getPos();
    }


}
