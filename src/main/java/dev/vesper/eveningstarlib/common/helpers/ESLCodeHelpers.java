package dev.vesper.eveningstarlib.common.helpers;

//? fabric{
import net.fabricmc.loader.api.FabricLoader;
//?} neoforge{
/*import net.neoforged.fml.loading.FMLEnvironment;
*///?}

public class ESLCodeHelpers {
    public static boolean isDevEnv(){
        //? fabric{
        return FabricLoader.getInstance().isDevelopmentEnvironment();
        //?} neoforge{
        /*return !FMLEnvironment.isProduction();
        *///?}
    }
}
