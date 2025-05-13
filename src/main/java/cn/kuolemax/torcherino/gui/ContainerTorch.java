package cn.kuolemax.torcherino.gui;

import cn.kuolemax.torcherino.tile.TileTorch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerTorch extends Container {
    private final TileTorch tile;

    public ContainerTorch(TileTorch tile) {
        this.tile = tile;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    public TileTorch getTile() {
        return tile;
    }
}
