package cn.kuolemax.torcherino.init;

import cn.kuolemax.torcherino.block.BlockCompressedTorch;
import cn.kuolemax.torcherino.block.BlockTorch;
import cn.kuolemax.torcherino.tile.TileCompressedTorch;
import cn.kuolemax.torcherino.tile.TileTorch;
import cpw.mods.fml.common.registry.GameRegistry;


public final class ModBlocks
{
    public static BlockTorch torcherino;
    public static BlockCompressedTorch compressedTorch;

    public static void init()
    {
        ModBlocks.torcherino = new BlockTorch();
        ModBlocks.compressedTorch = new BlockCompressedTorch();

        GameRegistry.registerBlock(ModBlocks.torcherino, ModBlocks.torcherino.getUnlocalizedName());
        GameRegistry.registerTileEntity(TileTorch.class, "torch_tile");
        GameRegistry.registerBlock(ModBlocks.compressedTorch, ModBlocks.compressedTorch.getUnlocalizedName());
        GameRegistry.registerTileEntity(TileCompressedTorch.class, "compressed_torch_tile");
    }

    private ModBlocks()
    {
    }
}
