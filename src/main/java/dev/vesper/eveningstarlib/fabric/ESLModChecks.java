package dev.vesper.eveningstarlib.fabric;
//? fabric {
import net.fabricmc.loader.api.FabricLoader;
import net.irisshaders.iris.api.v0.IrisApi;

public class ESLModChecks {

    public static boolean isIris(){
        return FabricLoader.getInstance().isModLoaded("iris");
    }

    public static boolean isShaders() {
        if (isIris()){
            return IrisApi.getInstance().getConfig().areShadersEnabled();
        } else {
            return false;
        }
    }

    public static boolean isSodium(){
        return FabricLoader.getInstance().isModLoaded("sodium");
    }
}
//?}