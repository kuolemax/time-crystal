package cn.kuolemax.torcherino.block;

import cn.kuolemax.torcherino.Torcherino;
import cn.kuolemax.torcherino.tile.TileTorch;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public final class BlockTorch extends net.minecraft.block.BlockTorch implements ITileEntityProvider {
    public BlockTorch() {
        this.setBlockName("torcherino.torch");
        this.setLightLevel(0.75f);
    }

    @Override
    public void onBlockAdded(final World world, final int x, final int y, final int z) {
        if (!world.isRemote) {
            // do something on block added
        }
    }

    @Override
    public void onNeighborBlockChange(final World world, final int x, final int y, final int z, final Block block) {
        if (!world.isRemote) {

        }

        super.onNeighborBlockChange(world, x, y, z, block);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            player.openGui(Torcherino.instance(), 0, world, x, y, z);
        }
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister r) {
        this.blockIcon = r.registerIcon("torcherino:torcherino");
    }

    @Override
    public TileEntity createNewTileEntity(final World world, final int i) {
        return new TileTorch();
    }
}
