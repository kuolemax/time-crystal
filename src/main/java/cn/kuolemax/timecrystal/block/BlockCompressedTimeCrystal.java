package cn.kuolemax.timecrystal.block;

import cn.kuolemax.timecrystal.tile.TileEntityCompressedTimeCrystal;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

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
