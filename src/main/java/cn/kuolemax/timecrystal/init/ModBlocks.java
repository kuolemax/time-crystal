package cn.kuolemax.timecrystal.init;

import cn.kuolemax.timecrystal.block.BlockCompressedTimeCrystal;
import cn.kuolemax.timecrystal.block.BlockDoubleCompressedTimeCrystal;
import cn.kuolemax.timecrystal.block.BlockTimeCrystal;
import cn.kuolemax.timecrystal.tile.TileEntityCompressedTimeCrystal;
import cn.kuolemax.timecrystal.tile.TileEntityDoubleCompressedTimeCrystal;
import cn.kuolemax.timecrystal.tile.TileEntityTimeCrystal;
import cpw.mods.fml.common.registry.GameRegistry;

public final class ModBlocks {

    public static BlockTimeCrystal timeCrystal;
    public static BlockCompressedTimeCrystal compressedTimeCrystal;
    public static BlockDoubleCompressedTimeCrystal doubleCompressedTimeCrystal;

    public static void init() {
        ModBlocks.timeCrystal = new BlockTimeCrystal();
        ModBlocks.compressedTimeCrystal = new BlockCompressedTimeCrystal();
        ModBlocks.doubleCompressedTimeCrystal = new BlockDoubleCompressedTimeCrystal();

        GameRegistry.registerBlock(ModBlocks.timeCrystal, ModBlocks.timeCrystal.getUnlocalizedName());
        GameRegistry.registerTileEntity(TileEntityTimeCrystal.class, "tile_time_crystal");
        GameRegistry
            .registerBlock(ModBlocks.compressedTimeCrystal, ModBlocks.compressedTimeCrystal.getUnlocalizedName());
        GameRegistry.registerTileEntity(TileEntityCompressedTimeCrystal.class, "tile_compressed_time_crystal");
        GameRegistry.registerBlock(
            ModBlocks.doubleCompressedTimeCrystal,
            ModBlocks.doubleCompressedTimeCrystal.getUnlocalizedName());
        GameRegistry
            .registerTileEntity(TileEntityDoubleCompressedTimeCrystal.class, "tile_double_compressed_time_crystal");
    }

    private ModBlocks() {}
}
