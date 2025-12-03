package cn.kuolemax.timecrystal.network;

import cn.kuolemax.timecrystal.TimeCrystal;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(TimeCrystal.MODID);

    private PacketHandler() {}

    public static void init() {
        INSTANCE.registerMessage(PacketUpdateTile.Handler.class, PacketUpdateTile.class, 0, Side.SERVER);
    }
}
