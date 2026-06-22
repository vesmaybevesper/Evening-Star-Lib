package dev.vesper.eveningstarlib.common;

//? fabric {
import net.fabricmc.loader.api.FabricLoader;
//?}
//? neoforge {
/*import dev.vesper.eveningstarlib.EveningStarLib;
import dev.vesper.eveningstarlib.common.helpers.ESLCodeHelpers;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
*///?}
import net.irisshaders.iris.api.v0.IrisApi;

public class ESLModChecks {

    public static boolean isIris(){
        //? fabric {
        return FabricLoader.getInstance().isModLoaded("iris");
        //?}
        //? neoforge {
        /*return ModList.get().isLoaded("iris");
        *///?}
    }

    public static boolean isShaders() {
        //? fabric || <26.2{
        if (isIris()){
            return IrisApi.getInstance().getConfig().areShadersEnabled();
        } else {
            return false;
        }
        //?} neoforge && >=26.2{
        /*if (ESLCodeHelpers.isDevEnv()){
            EveningStarLib.LOG.warn("IsShaders() currently always returns false on NeoForge due to Iris not supporting 26.2 Neo at time of release. If this is no longer the case please either check for an ESL update or (kindly) yell at me to update it! Thanks!");
        }
        return false;
        *///?}
    }


    public static boolean isSodium(){
        //? fabric {
        return FabricLoader.getInstance().isModLoaded("sodium");
        //?}
        //? neoforge {
        /*return ModList.get().isLoaded("sodium");
        *///?}
    }
}
