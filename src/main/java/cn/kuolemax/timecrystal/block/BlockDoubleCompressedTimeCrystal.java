package cn.kuolemax.timecrystal.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cn.kuolemax.timecrystal.tile.TileEntityDoubleCompressedTimeCrystal;

public class BlockDoubleCompressedTimeCrystal extends BlockTimeCrystal {

    public BlockDoubleCompressedTimeCrystal() {
        super();
        this.setBlockName("timecrystal.double_compressed_time_crystal");
        this.setBlockTextureName("timecrystal:double_compressed_time_crystal");
    }

    @Override
    public TileEntity createNewTileEntity(final World world, final int i) {
        return new TileEntityDoubleCompressedTimeCrystal();
    }
}
