package cn.kuolemax.timecrystal.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cn.kuolemax.timecrystal.tile.TileEntityBaseTimeCrystal;
import cpw.mods.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0) {
            TileEntity te = world.getTileEntity(x, y, z);
            if (te instanceof TileEntityBaseTimeCrystal t) {
                return new ContainerTimeCrystal(t);
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0) {
            TileEntity te = world.getTileEntity(x, y, z);
            if (te instanceof TileEntityBaseTimeCrystal t) {
                return new GuiTimeCrystal(t, new ContainerTimeCrystal(t));
            }
        }
        return null;
    }
}
