package cn.kuolemax.torcherino.gui;

import cn.kuolemax.torcherino.tile.TileTorch;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ModGuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0) {
            TileEntity te = world.getTileEntity(x, y, z);
            if (te instanceof TileTorch t) {
                return new ContainerTorch(t);
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0) {
            TileEntity te = world.getTileEntity(x, y, z);
            if (te instanceof TileTorch t) {
                return new GuiTorch(t, new ContainerTorch(t));
            }
        }
        return null;
    }
}

