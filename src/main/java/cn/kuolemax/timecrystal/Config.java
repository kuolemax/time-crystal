package cn.kuolemax.timecrystal;

import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static Configuration configuration;

    public static Boolean overPoweredRecipe = true;
    public static Boolean hidePotionEffects = true;

    public static void synchronizeConfiguration(File configFile) {
        configuration = new Configuration(configFile);

        ConfigCategory category = configuration.getCategory(Configuration.CATEGORY_GENERAL);
        category.setLanguageKey("config.category." + Configuration.CATEGORY_GENERAL);

        synchronizeConfiguration();
    }

    public static void synchronizeConfiguration() {

        overPoweredRecipe = configuration.getBoolean("OverPoweredRecipe", Configuration.CATEGORY_GENERAL, overPoweredRecipe, "Is the recipe for timecrystal extremely OP?", "config.property.OverPoweredRecipe");
        hidePotionEffects = configuration.getBoolean("HidePotionEffects", Configuration.CATEGORY_GENERAL, hidePotionEffects, "Hide potion effects?", "config.property.HidePotionEffects");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
