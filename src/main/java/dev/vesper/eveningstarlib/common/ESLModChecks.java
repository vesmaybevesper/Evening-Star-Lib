package dev.vesper.eveningstarlib.common;

//? fabric {
import net.irisshaders.iris.api.v0.IrisApi;
//?}
import dev.vesper.eveningstarlib.EveningStarLib;

public class ESLModChecks {

    public static boolean isIris(){
        return EveningStarLib.isModLoaded("iris");
    }

    public static boolean isShaders() {
        if (isIris()){
            return IrisApi.getInstance().getConfig().areShadersEnabled();
        } else {
            return false;
        }
    }


    public static boolean isSodium(){
       return EveningStarLib.isModLoaded("sodium");
    }
}
