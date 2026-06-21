/*
package dev.vesper.eveningstarlib.common.Aurora;

import com.google.common.annotations.Beta;
import io.netty.util.internal.UnstableApi;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// WIP disabled in production until its more ready :)

@UnstableApi
@Beta
public class Aurora {

    private static final Map<String, UniformData> uniforms = new ConcurrentHashMap<>();
    private static final Map<String, UniformType> registeredUniforms = new ConcurrentHashMap<>();

    public static boolean registerUniform(String name, UniformType uniformType) {
        if (uniforms.containsKey(name))
            return false;

        registeredUniforms.put(name, uniformType);
        uniforms.put(name, new UniformData(uniformType, getDefaultValue(uniformType)));

        return true;
    }

    public static void setUniform(String name, float value) {
        validateAndSet(name, UniformType.FLOAT, value);
    }

    public static void setUniform(String name, int value) {
        validateAndSet(name, UniformType.INT, value);
    }

    public static void setUniform(String name, float x, float y) {
        validateAndSet(name, UniformType.VEC2, new float[]{x,y});
    }

    public static void setUniform(String name, float x, float y, float z) {
        validateAndSet(name, UniformType.VEC3, new float[]{x,y,z});
    }

    public static void setUniform(String name, float x, float y, float z, float w) {
        validateAndSet(name, UniformType.VEC4, new float[]{x,y,z,w});
    }

    public static void setUniform(String name, boolean value) {
        validateAndSet(name, UniformType.BOOL, value ?  1 : 0);
    }

    public static Object getUniform(String name) {
        UniformData uniformData = uniforms.get(name);
        return uniformData != null ? uniformData.value : null;
    }

    public static boolean isRegistered(String name) {
        return registeredUniforms.containsKey(name);
    }

    public static Map<String, UniformData> getAllUniforms() {
        return new HashMap<>(uniforms);
    }

    public static Map<String, UniformType> getRegisteredUniformTypes() {
        return new HashMap<>(registeredUniforms);
    }

    private static void validateAndSet(String name, UniformType expectedType, Object value) {
        if (!registeredUniforms.containsKey(name)){
            throw new IllegalArgumentException("Uniform " + name + " not registered");
        }

        UniformType registeredType = registeredUniforms.get(name);
        if (registeredType != expectedType && !(registeredType == UniformType.BOOL && expectedType == UniformType.INT)) {
            throw new IllegalArgumentException("Uniform " + name + " is already registered as " + registeredType);
        }

        uniforms.put(name, new UniformData(expectedType, value));
    }

    public static Object getDefaultValue(UniformType uniformType) {
        return switch (uniformType) {
            case FLOAT -> 0.0f;
            case INT, BOOL -> 0;
            case VEC2 -> new float[]{0.0f, 0.0f};
            case VEC3 -> new float[]{0.0f, 0.0f, 0.0f};
            case VEC4 -> new float[]{0.0f, 0.0f, 0.0f, 0.0f};
            default -> null;
        };
    }

    public static class UniformData {
        public final UniformType type;
        public final Object value;

        public UniformData(UniformType type, Object value) {
            this.type = type;
            this.value = value;
        }
    }

    public enum UniformType {
        FLOAT("float"),
        INT("int"),
        BOOL("bool"),
        VEC2("vec2"),
        VEC3("vec3"),
        VEC4("vec4");

        private final String glslType;

        UniformType(String glslType){
            this.glslType = glslType;
        }

        public String getGlslType(){
            return glslType;
        }
    }
}
*/
