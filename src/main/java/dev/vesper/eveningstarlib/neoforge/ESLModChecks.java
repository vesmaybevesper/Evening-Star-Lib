package dev.vesper.eveningstarlib.neoforge;
//? neoforge {

/*import net.irisshaders.iris.api.v0.IrisApi;
import net.neoforged.fml.ModList;

public class ESLModChecks {

    public static boolean isIris(){
        return ModList.get().isLoaded("iris");
    }

    public static boolean isShaders() {
        if (isIris()){
            return IrisApi.getInstance().getConfig().areShadersEnabled();
        } else {
            return false;
        }
    }

    public static boolean isSodium(){
        return ModList.get().isLoaded("sodium");
    }
}
*///?}