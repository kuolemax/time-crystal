package cn.kuolemax.torcherino.tile;

import cn.kuolemax.torcherino.init.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import java.util.Random;

public class TileTorch extends TileEntity {
    private static final ImmutableSet<Block> blacklist = ImmutableSet.of(
        Blocks.air,
        Blocks.bedrock,
        Blocks.obsidian,
        Blocks.stone,
        Blocks.glowstone,
        Blocks.netherrack,
        Blocks.sand,
        Blocks.gravel,
        ModBlocks.torcherino,
        ModBlocks.compressedTorch,
        ModBlocks.doubleCompressedTorch);

    private int xMin;
    private int yMin;
    private int zMin;
    private int xMax;
    private int yMax;
    private int zMax;

    private final Random rand;

    private int speedIndex = 0;
    private int speed = 0;
    private int range = 1;

    public TileTorch() {
        this.rand = new Random();
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setInteger("speed", speed);
        tag.setInteger("range", range);
        tag.setInteger("speedIndex", speedIndex);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        speed = tag.getInteger("speed");
        range = tag.getInteger("range");
        speedIndex = tag.getInteger("speedIndex");
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbt);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.func_148857_g()); // 1.7.10的方法名
    }


    @Override
    public void updateEntity() {
        if (worldObj.isRemote) return;

        if (this.speed == 0)
            return;

        calculateRange();
        timeSpeedsUp();
    }

    private void calculateRange() {
        this.xMin = this.xCoord - this.range;
        this.yMin = this.yCoord - 1;
        this.zMin = this.zCoord - this.range;
        this.xMax = this.xCoord + this.range;
        this.yMax = this.yCoord + 1;
        this.zMax = this.zCoord + this.range;
    }

    private void timeSpeedsUp() {
        for (int x = this.xMin; x <= this.xMax; x++) {
            for (int y = this.yMin; y <= this.yMax; y++) {
                for (int z = this.zMin; z <= this.zMax; z++) {
                    final Block block = this.worldObj.getBlock(x, y, z);

                    if (blacklist.contains(block))
                        continue;

                    if (block.getTickRandomly()) {
                        for (int i = 0; i < this.speed; i++)
                            block.updateTick(this.worldObj, x, y, z, this.rand);
                    }

                    if (block.hasTileEntity(this.worldObj.getBlockMetadata(x, y, z))) {
                        final TileEntity tile = this.worldObj.getTileEntity(x, y, z);
                        if (tile != null && !(tile instanceof TileTorch) && !tile.isInvalid()) {
                            for (int i = 0; i < this.speed; i++)
                                tile.updateEntity();
                        }
                    }
                }
            }
        }
    }

    public void setSpeedWithIndex(int speedIndex) {
        this.speedIndex = speedIndex;
        this.speed = getSpeeds()[speedIndex];
    }

    public int getSpeed() {
        return speed;
    }

    public int getSpeedIndex() {
        return this.speedIndex;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    public int[] getSpeeds() {
        return new int[]{0, 1, 2, 3, 4};
    }
}
