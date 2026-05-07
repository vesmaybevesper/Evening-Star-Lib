package dev.vesper.eveningstarlib.common;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;

public class ESLRenderUtils {
    public static Camera getCamera(){
        //? <=26.1{
        /*return Minecraft.getInstance().gameRenderer.getMainCamera();
        *///? } >=26.2{
        return Minecraft.getInstance().gameRenderer.mainCamera();
        //?}
    }
    public static Vec3 getCameraPos(){
        Camera camera = getCamera();
        return camera.position();
    }
}
