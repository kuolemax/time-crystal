package cn.kuolemax.torcherino.gui;

import cn.kuolemax.torcherino.Config;
import cn.kuolemax.torcherino.Torcherino;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ModGuiConfig extends GuiConfig {
    public ModGuiConfig(GuiScreen parentScreen) {
        super(
            parentScreen,
            getAllConfigElements(),
            Torcherino.MODID,
            false,
            false,
            GuiConfig.getAbridgedConfigPath(Config.configuration.toString())
        );
    }

    /**
     * 生成所有分类的 GUI 元素列表，包括 GENERAL 和自定义分类
     */
    private static List<IConfigElement> getAllConfigElements() {
        List<IConfigElement> elements = new ArrayList<>();
        Configuration cfg = Config.configuration;

        // 遍历所有分类，并生成对应的 ConfigElement
        for (String categoryName : cfg.getCategoryNames()) {
            // 跳过空分类或特殊前缀可在此过滤
            elements.add(
                new ConfigElement(cfg.getCategory(categoryName))
            );
        }
        return elements;
    }
}
