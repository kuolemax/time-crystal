package cn.kuolemax.timecrystal.gui;

import cn.kuolemax.timecrystal.tile.TileEntityBaseTimeCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

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
