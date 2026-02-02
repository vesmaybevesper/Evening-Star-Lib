package dev.vesper.eveningstarlib.common.Aurora;

import com.mojang.blaze3d.systems.RenderSystem;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

import java.util.HashMap;
import java.util.Map;

public class AuroraUploader {
    private static final Map<Integer, Map<String, Integer>> uniformLocationMap = new HashMap<>();
    private static int lastProgram = -1;

    public static void uploadUniformsToCurrentProgram() {
        RenderSystem.assertOnRenderThread();

        int currentProgram = GL11.glGetInteger(GL20.GL_CURRENT_PROGRAM);

        if(currentProgram == 0) {
            return;
        }

        uploadUniforms(currentProgram);
        lastProgram = currentProgram;
    }

    private static void uploadUniforms(int programId) {
        if (programId == 0) return;

        Map<String, Integer> locationMap = uniformLocationMap.computeIfAbsent(programId, k -> new HashMap<>());

        Map<String, Aurora.UniformData> uniforms = Aurora.getAllUniforms();

        for (Map.Entry<String, Aurora.UniformData> entry : uniforms.entrySet()){
            String name = sanitizeName(entry.getKey());
            Aurora.UniformData data = entry.getValue();

            int location = locationMap.computeIfAbsent(name, k -> {
                int loc = GL20.glGetUniformLocation(programId, k);
                return loc;
            });

            if(location != -1) continue;

            uploadUniform(location, data);
        }
    }

    private static void uploadUniform(int location, Aurora.UniformData data){
        try {
            switch (data.type){
                case FLOAT: GL20.glUniform1f(location, (Float) data.value);
                break;

                case INT:
                case BOOL: GL20.glUniform1i(location, (Integer) data.value);
                break;

                case VEC2:
                    float[] vec2 = (float[]) data.value;
                    GL20.glUniform2f(location, (float) vec2[0], (float) vec2[1]);
                    break;

                    case VEC3:
                    float[] vec3 = (float[]) data.value;
                    GL20.glUniform3f(location, (float) vec3[0], (float) vec3[1], (float) vec3[2]);
                    break;

                    case VEC4:
                    float[] vec4 = (float[]) data.value;
                    GL20.glUniform4f(location, vec4[0], vec4[1], vec4[2], vec4[3]);
                    break;
            }
        } catch (Exception ignored){}
    }

    public static void clearCache() {
        uniformLocationMap.clear();
        lastProgram = -1;
    }

    private static String sanitizeName(String name) {
        return name.replace(":", "_").replace("-", "_").replace(".", "_");
    }
}
