package cn.kuolemax.torcherino;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static Boolean overPoweredRecipe = true;
    public static Boolean hidePotionEffects = true;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        overPoweredRecipe = configuration.getBoolean("OverPoweredRecipe", Configuration.CATEGORY_GENERAL, overPoweredRecipe, "Is the recipe for Torcherino extremely OP?");
        hidePotionEffects = configuration.getBoolean("OverPoweredRecipe", Configuration.CATEGORY_GENERAL, hidePotionEffects, "是否隐藏背包内的药水效果列表?");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
