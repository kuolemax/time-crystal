package cn.kuolemax.torcherino;

import cn.kuolemax.torcherino.init.CommonProxy;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Torcherino.MODID, version = Tags.VERSION, name = "Torcherino", acceptedMinecraftVersions = "[1.7.10]", guiFactory = "cn.kuolemax.torcherino.gui.ConfigGuiFactory")
public class Torcherino {

    private static Torcherino instance;

    public static final String MODID = "torcherino";
    public static final Logger LOG = LogManager.getLogger(MODID);

    @Mod.InstanceFactory
    public static Torcherino instance() {
        if (Torcherino.instance == null)
            Torcherino.instance = new Torcherino();
        return Torcherino.instance;
    }

    @SidedProxy(clientSide = "cn.kuolemax.torcherino.init.ClientProxy", serverSide = "cn.kuolemax.torcherino.init.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        FMLCommonHandler.instance().bus().register(new ConfigHandler());
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }

    public static class ConfigHandler {
        @SubscribeEvent
        public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent e) {
            if (e.modID.equals(MODID)) {
                Config.synchronizeConfiguration();
            }
        }
    }
}
