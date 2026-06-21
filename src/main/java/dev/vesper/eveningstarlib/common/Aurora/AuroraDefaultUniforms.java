/*
package dev.vesper.eveningstarlib.common.Aurora;

import com.google.common.annotations.Beta;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.phys.Vec3;
import net.minecraft.resources.Identifier;
import org.apache.logging.log4j.util.InternalApi;

// WIP disabled in production until its more ready :)

@InternalApi
@Beta
public class AuroraDefaultUniforms {

    private static int lastDimensionId = -1;
    private static float lastRainStrength = -1;
    private static float lastThunderStrength = -1;

    public static void registerAll() {
        Aurora.registerUniform("worldTime", Aurora.UniformType.INT);
        Aurora.registerUniform("sunAngle", Aurora.UniformType.FLOAT);
        Aurora.registerUniform("rainStrength", Aurora.UniformType.FLOAT);
        Aurora.registerUniform("isRaining", Aurora.UniformType.BOOL);
        Aurora.registerUniform("thunderStrength", Aurora.UniformType.FLOAT);
        Aurora.registerUniform("isOverworld", Aurora.UniformType.BOOL);
        Aurora.registerUniform("isNether", Aurora.UniformType.BOOL);
        Aurora.registerUniform("isEnd", Aurora.UniformType.BOOL);
        Aurora.registerUniform("playerX", Aurora.UniformType.FLOAT);
        Aurora.registerUniform("playerY", Aurora.UniformType.FLOAT);
        Aurora.registerUniform("playerZ", Aurora.UniformType.FLOAT);
        Aurora.registerUniform("playerPos", Aurora.UniformType.VEC3);
        Aurora.registerUniform("isUnderwater", Aurora.UniformType.BOOL);
        Aurora.registerUniform("isInLava", Aurora.UniformType.BOOL);
        Aurora.registerUniform("cameraX", Aurora.UniformType.FLOAT);
        Aurora.registerUniform("cameraY", Aurora.UniformType.FLOAT);
        Aurora.registerUniform("cameraZ", Aurora.UniformType.FLOAT);
        Aurora.registerUniform("cameraPos", Aurora.UniformType.VEC3);
        Aurora.registerUniform("moonPhase", Aurora.UniformType.INT);
        Aurora.registerUniform("skyLight", Aurora.UniformType.INT);
    }

    public static void updateAll() {
        Minecraft minecraft  = Minecraft.getInstance();
        if(minecraft.player == null || minecraft.level == null) return;

        updateTimeAndWeather(minecraft);
        updateBiomeInfo(minecraft);
        updateDimensionInfo(minecraft);
        updatePlayerInfo(minecraft);
        updateCameraInfo(minecraft);
        updateLightInfo(minecraft);
    }

    private static void updateLightInfo(Minecraft minecraft) {
        assert minecraft.player != null;
        BlockPos pos = minecraft.player.blockPosition();

        assert minecraft.level != null;
        long dayNumber = minecraft.level.getDefaultClockTime() / 24000L;
        int moonPhase = (int) (dayNumber % 8L);
        Aurora.setUniform("moonPhase", moonPhase);


        int skyLight = minecraft.level.getBrightness(LightLayer.SKY, pos);
        Aurora.setUniform("skyLight", skyLight);
    }

    private static void updateCameraInfo(Minecraft minecraft) {
        //? <=26.1{
        */
/*Vec3 cameraPos = minecraft.gameRenderer.getMainCamera().position();
        *//*
//?} >=26.2{
        Vec3 cameraPos = minecraft.gameRenderer.mainCamera().position();
        //?}
        Aurora.setUniform("cameraX", (float) cameraPos.x);
        Aurora.setUniform("cameraY", (float) cameraPos.y);
        Aurora.setUniform("cameraZ", (float) cameraPos.z);
        Aurora.setUniform("cameraPos", (float) cameraPos.x, (float) cameraPos.y, (float) cameraPos.z);
    }

    private static void updatePlayerInfo(Minecraft minecraft) {
        LocalPlayer player = minecraft.player;
        assert player != null;
        Vec3 pos = player.position();

        Aurora.setUniform("playerX", (float) pos.x);
        Aurora.setUniform("playerY", (float) pos.y);
        Aurora.setUniform("playerZ", (float) pos.z);
        Aurora.setUniform("playerPos", (float) pos.x, (float) pos.y, (float) pos.z);
        Aurora.setUniform("isUnderwater", player.isUnderWater());
        Aurora.setUniform("isInLava", player.isInLava());
    }

    private static void updateDimensionInfo(Minecraft minecraft) {
        ClientLevel level = minecraft.level;
        assert level != null;
        Identifier dimLocation = level.dimension().identifier();

        int dimId = calculateDim(dimLocation);

        if (dimId != lastDimensionId){
            Aurora.setUniform("isOverworld", dimId == 0);
            Aurora.setUniform("isNether", dimId == 1);
            Aurora.setUniform("isEnd", dimId == 2);
            lastDimensionId = dimId;
        }
    }

    private static void updateBiomeInfo(Minecraft minecraft) {
    }

    //*
    //* Sun Angle calculation derived from Iris
    //*
    private static void updateTimeAndWeather(Minecraft minecraft) {
        ClientLevel level = minecraft.level;

        assert level != null;
        long worldTime = level.getDefaultClockTime();
        //this SHOULD be correct but i need to test a lot more
        //? <=26.1{
        */
/*float currentAngle = Minecraft.getInstance().gameRenderer.getMainCamera().attributeProbe().getValue(EnvironmentAttributes.SUN_ANGLE, Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(true));
        *//*
//?} >=26.2 {
        float currentAngle = Minecraft.getInstance().gameRenderer.mainCamera().attributeProbe().getValue(EnvironmentAttributes.SUN_ANGLE, Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(true));
        //?}

        float sunAngle = currentAngle + 90.0f;

        if (sunAngle < 0) {
            sunAngle += 360.0f;
        } else if (sunAngle > 360.0f) {
            sunAngle -= 360.0f;
        }

        Aurora.setUniform("worldTime", worldTime);
        Aurora.setUniform("sunAngle", sunAngle);

        float rainStrength = level.getRainLevel(1.0f);
        float thunderStrength = level.getThunderLevel(1.0f);

        if (rainStrength != lastRainStrength) {
            Aurora.setUniform("rainStrength", rainStrength);
            Aurora.setUniform("isRaining", rainStrength > 0.0f);
            lastRainStrength = rainStrength;
        }

        if (thunderStrength != lastThunderStrength) {
            Aurora.setUniform("thunderStrength", thunderStrength);
            Aurora.setUniform("isThundering", thunderStrength > 0.0f);
            lastThunderStrength = thunderStrength;
        }
    }

    private static int calculateDim(Identifier dimLocation) {
        String path = dimLocation.getPath();

        if (path.contains("overworld")) return 0;
        if (path.contains("the_nether")) return 1;
        if (path.contains("the_end")) return 2;
        return 99;
    }
}
*/
