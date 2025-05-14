package cn.kuolemax.torcherino;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static Boolean overPoweredRecipe = true;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        overPoweredRecipe = configuration.getBoolean("OverPoweredRecipe", Configuration.CATEGORY_GENERAL, overPoweredRecipe, "Is the recipe for Torcherino extremely OP?");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
