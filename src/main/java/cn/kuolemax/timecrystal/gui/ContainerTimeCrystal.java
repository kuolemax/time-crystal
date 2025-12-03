package cn.kuolemax.timecrystal.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

import cn.kuolemax.timecrystal.tile.TileEntityBaseTimeCrystal;

public class ContainerTimeCrystal extends Container {

    private final TileEntityBaseTimeCrystal tile;

    public ContainerTimeCrystal(TileEntityBaseTimeCrystal tile) {
        this.tile = tile;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    public TileEntityBaseTimeCrystal getTile() {
        return tile;
    }
}
