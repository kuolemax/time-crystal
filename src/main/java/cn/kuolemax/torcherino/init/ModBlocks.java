package cn.kuolemax.torcherino.init;

import cn.kuolemax.torcherino.block.BlockTorch;
import cn.kuolemax.torcherino.tile.TileTorch;
import cpw.mods.fml.common.registry.GameRegistry;


public final class ModBlocks
{
    public static BlockTorch torcherino;

    public static void init()
    {
        ModBlocks.torcherino = new BlockTorch();

        GameRegistry.registerBlock(ModBlocks.torcherino, ModBlocks.torcherino.getUnlocalizedName());
        GameRegistry.registerTileEntity(TileTorch.class, "torch_tile");
    }

    private ModBlocks()
    {
    }
}
