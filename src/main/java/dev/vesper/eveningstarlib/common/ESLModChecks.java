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
        //? fabric || <26.2{
        if (isIris()){
            return IrisApi.getInstance().getConfig().areShadersEnabled();
        } else {
            return false;
        }
        //?} neoforge && >=26.2{
        /*if (EveningStarLib.isDevEnv()) EveningStarLib.LOG.warn("IsShaders() currently always returns false on NeoForge due to Iris not supporting 26.2 Neo at time of release. If this is no longer the case please either check for an ESL update or (kindly) yell at me to update it! Thanks!");
        return false;
        *///?}
    }


    public static boolean isSodium(){
       return EveningStarLib.isModLoaded("sodium");
    }
}
