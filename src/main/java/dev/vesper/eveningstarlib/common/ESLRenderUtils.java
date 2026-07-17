package dev.vesper.eveningstarlib.common;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;

public class ESLRenderUtils {
    /**
     * Returns the clients main camera
     * @return Camera
     */
    public static Camera getCamera(){
        //? <=26.1{
        /*return Minecraft.getInstance().gameRenderer.getMainCamera();
        *///? } >=26.2{
        return Minecraft.getInstance().gameRenderer.mainCamera();
        //?}
    }

    /**
     * Returns the location of the main camera
     * @return Vec3
     */
    public static Vec3 getCameraPos(){
        Camera camera = getCamera();
        return camera.position();
    }
}
