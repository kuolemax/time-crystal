package cn.kuolemax.timecrystal.init;

import cn.kuolemax.timecrystal.render.ItemRendererCrystal;
import cn.kuolemax.timecrystal.render.RenderCrystal;
import cn.kuolemax.timecrystal.tile.TileEntityCompressedTimeCrystal;
import cn.kuolemax.timecrystal.tile.TileEntityDoubleCompressedTimeCrystal;
import cn.kuolemax.timecrystal.tile.TileEntityTimeCrystal;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import static cn.kuolemax.timecrystal.TimeCrystal.LOG;

public class ClientProxy extends CommonProxy {

    @Override
    public void init(FMLInitializationEvent event) {
        LOG.info("注册渲染器 RenderCrystal");
        // TESR 渲染方块
        RenderCrystal renderCrystal = new RenderCrystal();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTimeCrystal.class, renderCrystal);
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCompressedTimeCrystal.class, renderCrystal);
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDoubleCompressedTimeCrystal.class, renderCrystal);
        // 注册物品渲染器
        ItemRendererCrystal itemRendererCrystal = new ItemRendererCrystal();
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.timeCrystal), itemRendererCrystal);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.compressedTimeCrystal), itemRendererCrystal);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.doubleCompressedTimeCrystal), itemRendererCrystal);
    }
}
