package dev.vesper.eveningstarlib.common.Aurora;

import com.google.common.annotations.Beta;
import com.mojang.blaze3d.systems.RenderSystem;
import org.apache.logging.log4j.util.InternalApi;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.vulkan.VK10.*;

// WIP disabled in production until its more ready :)

@InternalApi
@Beta
public class AuroraUploader {
    //? >= 26.2 {
    private static final Map<Long, Map<String, Integer>> pushConstantOffsetMap = new HashMap<>();
    private static final int PUSH_CONSTANT_STAGES = VK_SHADER_STAGE_VERTEX_BIT | VK_SHADER_STAGE_FRAGMENT_BIT;
    private static final int SLOT_SIZE = 4 * Float.BYTES;

    public static void uploadUniformsToCurrentProgram(VkCommandBuffer commandBuffer, long pipelineLayout) {
        RenderSystem.assertOnRenderThread();

        if (commandBuffer == null || pipelineLayout == VK_NULL_HANDLE) {
            return;
        }

        uploadUniforms(commandBuffer, pipelineLayout);
    }

    private static void uploadUniforms(VkCommandBuffer commandBuffer, long pipelineLayout) {
        Map<String, Aurora.UniformData> uniforms = Aurora.getAllUniforms();
        if (uniforms.isEmpty()) return;

        Map<String, Integer> offsetMap = pushConstantOffsetMap.computeIfAbsent(pipelineLayout, k -> new HashMap<>());

        int nextOffset = offsetMap.values().stream().mapToInt(v -> v).max().orElse(-SLOT_SIZE) + SLOT_SIZE;
        for (String rawName : uniforms.keySet()) {
            String name = sanitizeName(rawName);
            if(!offsetMap.containsKey(name)){
                offsetMap.put(name, nextOffset);
                nextOffset += SLOT_SIZE;
            }
        }

        int blockSize = nextOffset;

        try (MemoryStack stack = MemoryStack.stackPush()) {
            ByteBuffer pushData = stack.calloc(blockSize);

            for (Map.Entry<String, Aurora.UniformData> entry : uniforms.entrySet()) {
                String name = sanitizeName(entry.getKey());
                Aurora.UniformData data = entry.getValue();
                int offset = offsetMap.get(name);
                uploadUniforms(pushData, offset, data);
            }

            pushData.rewind();
            vkCmdPushConstants(commandBuffer, pipelineLayout, PUSH_CONSTANT_STAGES, 0, pushData);

        }
    }

    private static void uploadUniforms(ByteBuffer buffer, int byteOffset, Aurora.UniformData data){
        try {
            switch (data.type){
                case FLOAT:
                    buffer.putFloat(byteOffset, (Float) data.value);
                    break;

                case INT:
                case BOOL:
                    buffer.putInt(byteOffset, (Integer) data.value);
                    break;

                case VEC2:{
                    float[] v = (float[]) data.value;
                    buffer.putFloat(byteOffset, (float) v[0]);
                    buffer.putFloat(byteOffset + Float.BYTES, (float) v[1]);
                    break;
                }

                case VEC3:{
                    float[] v = (float[]) data.value;
                    buffer.putFloat(byteOffset, (float) v[0]);
                    buffer.putFloat(byteOffset + Float.BYTES, (float) v[1]);
                    buffer.putFloat(byteOffset + Float.BYTES * 2, (float) v[2]);
                    break;
                }

                case VEC4:{
                    float[] v = (float[]) data.value;
                    buffer.putFloat(byteOffset, (float) v[0]);
                    buffer.putFloat(byteOffset + Float.BYTES, (float) v[1]);
                    buffer.putFloat(byteOffset + Float.BYTES * 2, (float) v[2]);
                    buffer.putFloat(byteOffset + Float.BYTES * 3, (float) v[3]);
                    break;
                }
            }
        } catch (Exception ignored){}
    }

    public static void clearCache() {
        pushConstantOffsetMap.clear();
    }

    private static String sanitizeName(String name) {
        return name.replace(":", "_").replace("-", "_").replace(".", "_");
    }
    //?}
}