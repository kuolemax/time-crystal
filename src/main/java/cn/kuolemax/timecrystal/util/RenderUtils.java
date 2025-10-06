package cn.kuolemax.timecrystal.util;

import net.minecraft.util.ResourceLocation;

public class RenderUtils {

    public static ResourceLocation getBlockTexture(String texturePath) {
        String name = texturePath;
        if (name == null) {
            // 防止NPE，返回一个备用贴图
            return new ResourceLocation("minecraft:textures/blocks/stone.png");
        }

        // 如果没有冒号，默认加上 modid
        if (!name.contains(":")) {
            name = "minecraft:" + name;
        }

        // Forge 的 block 贴图路径规则是 "textures/blocks/<name>.png"
        // 但如果你的模型贴图单独放在 "textures/models/" 目录，则可在此调整
        String domain = name.substring(0, name.indexOf(':'));
        String path = name.substring(name.indexOf(':') + 1);

        // 假设我们希望贴图在 models 目录中
        return new ResourceLocation(domain, "textures/blocks/" + path + ".png");
    }
}
