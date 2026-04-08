package dev.vesper.eveningstarlib;

//? fabric {
/*import dev.vesper.eveningstarlib.fabric.FabricPlatformImpl;
*///?}
//? neoforge {
import dev.vesper.eveningstarlib.neoforge.NeoforgePlatformImpl;
//?}

public interface Platform {

    //? fabric {
    /*Platform INSTANCE = new FabricPlatformImpl();
    *///?}
    //? neoforge {
    Platform INSTANCE = new NeoforgePlatformImpl();
    //?}


    boolean isModLoaded(String modid);
    String loader();

}
