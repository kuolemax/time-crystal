package cn.kuolemax.timecrystal.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cn.kuolemax.timecrystal.tile.TileEntityCompressedTimeCrystal;

public class BlockCompressedTimeCrystal extends BlockTimeCrystal {

    public BlockCompressedTimeCrystal() {
        super();
        this.setBlockName("timecrystal.compressed_time_crystal");
        this.setBlockTextureName("timecrystal:compressed_time_crystal");
    }

    @Override
    public TileEntity createNewTileEntity(final World world, final int i) {
        return new TileEntityCompressedTimeCrystal();
    }
}
