package dev.vesper.eveningstarlib.common;

//? fabric {
import net.fabricmc.loader.api.FabricLoader;
import net.irisshaders.iris.api.v0.IrisApi;
//?}
//? neoforge {
/*import net.neoforged.fml.ModList;
*///?}

public class ESLModChecks {

    public static boolean isIris(){
        //? fabric {
        return FabricLoader.getInstance().isModLoaded("iris");
        //?}
        //? neoforge {
        /*return ModList.get().isLoaded("iris");
        *///?}
    }
//? fabric {
    public static boolean isShaders() {
        if (isIris()){
            return IrisApi.getInstance().getConfig().areShadersEnabled();
        } else {
            return false;
        }
    }
    //?}

    public static boolean isSodium(){
        //? fabric {
        return FabricLoader.getInstance().isModLoaded("sodium");
        //?}
        //? neoforge {
        /*return ModList.get().isLoaded("sodium");
        *///?}
    }
}
