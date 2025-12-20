package dev.vesper.eveningstarlib.common;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;

public class ESLRenderUtils {
    public static Camera getCamera(){
        return Minecraft.getInstance().gameRenderer.getMainCamera();
    }
//? >=1.21.6 {
    /*public static Vec3 getCameraPos(){
        Camera camera = getCamera();
        return camera.position();
    }
    *///?}
    //? < 1.21.6 {
    public static Vec3 getCameraPos(){
        Camera camera = getCamera();
        return camera.getPosition();
    }
    //?}
}
