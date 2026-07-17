package dev.vesper.eveningstarlib.common;

import dev.vesper.eveningstarlib.EveningStarLib;
import net.irisshaders.iris.api.v0.IrisApi;

public class ESLModChecks {

    /**
     * Checks if Iris is present and returns the appropriate boolean
     * @return boolean
     */
    public static boolean isIris(){
        return EveningStarLib.isModLoaded("iris");
    }

    /**
     * If Iris is installed it returns a boolean representing if a shader pack is currently enabled, otherwise it returns false
     * @return boolean
     */
    public static boolean isShaders() {
        if (isIris()){
            return IrisApi.getInstance().getConfig().areShadersEnabled();
        } else {
            return false;
        }
    }

    /**
     * Checks if Sodium is present and returns the appropriate boolean
     * @return boolean
     */
    public static boolean isSodium(){
       return EveningStarLib.isModLoaded("sodium");
    }
}
