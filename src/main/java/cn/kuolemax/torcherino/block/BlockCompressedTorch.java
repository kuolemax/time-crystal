package cn.kuolemax.torcherino.block;

import cn.kuolemax.torcherino.tile.TileCompressedTorch;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCompressedTorch extends BlockTorch {
    public BlockCompressedTorch() {
        super();
        this.setBlockName("torcherino.compressed_torch");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister r) {
        this.blockIcon = r.registerIcon("torcherino:compressed_torcherino");
    }

    @Override
    public TileEntity createNewTileEntity(final World world, final int i) {
        return new TileCompressedTorch();
    }
}
