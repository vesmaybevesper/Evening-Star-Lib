package dev.vesper.eveningstarlib.common;

public class ESLMathUtils {
    public float getTimeOfDay(long daytime){

    }

    public float getSunAngle(float partialTicks) {
        float f = this.getTimeOfDay(partialTicks);
        return f * ((float)Math.PI * 2F);
    }
}
