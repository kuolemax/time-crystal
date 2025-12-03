package cn.kuolemax.timecrystal.init;

import cn.kuolemax.timecrystal.Config;
import cn.kuolemax.timecrystal.TimeCrystal;
import cn.kuolemax.timecrystal.gui.ModGuiHandler;
import cn.kuolemax.timecrystal.network.PacketHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class CommonProxy {

    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        TimeCrystal.hasGregTech = Loader.isModLoaded("gregtech");

        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());

        NetworkRegistry.INSTANCE.registerGuiHandler(TimeCrystal.instance(), new ModGuiHandler());
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
