package cn.kuolemax.torcherino.init;

import cn.kuolemax.torcherino.Config;
import cn.kuolemax.torcherino.Tags;
import cn.kuolemax.torcherino.Torcherino;
import cn.kuolemax.torcherino.gui.ModGuiHandler;
import cn.kuolemax.torcherino.network.PacketHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class CommonProxy {

    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());

        Torcherino.LOG.info(Config.overPoweredRecipe);
        Torcherino.LOG.info("I am MyMod at version " + Tags.VERSION);

        NetworkRegistry.INSTANCE.registerGuiHandler(Torcherino.instance(), new ModGuiHandler());
        PacketHandler.init();

        ModBlocks.init();
        Recipes.init();
    }

    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {}

    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {}

    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {}
}
