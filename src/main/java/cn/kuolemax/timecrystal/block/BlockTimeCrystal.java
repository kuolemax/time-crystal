package cn.kuolemax.timecrystal.block;

import cn.kuolemax.timecrystal.TimeCrystal;
import cn.kuolemax.timecrystal.tile.TileEntityTimeCrystal;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class BlockTimeCrystal extends BlockContainer {

    public BlockTimeCrystal() {
        super(Material.circuits);
        this.setBlockName("timecrystal.time_crystal");
        this.setBlockTextureName("timecrystal:time_crystal");
        this.setLightLevel(1f);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            player.openGui(TimeCrystal.instance(), 0, world, x, y, z);
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(final World world, final int i) {
        return new TileEntityTimeCrystal();
    }

    @Override
    public void addCollisionBoxesToList(World worldIn, int x, int y, int z, AxisAlignedBB mask, List<AxisAlignedBB> list, Entity collider) {
        // remove collision box
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        // 移除碰撞箱
        return null;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    public String getPublicTextureName() {
        return textureName;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return Blocks.glass.getIcon(0, 0);
    }
}
