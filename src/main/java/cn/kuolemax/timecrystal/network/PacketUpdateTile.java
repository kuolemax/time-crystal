package cn.kuolemax.timecrystal.network;

import cn.kuolemax.timecrystal.tile.TileEntityBaseTimeCrystal;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class PacketUpdateTile implements IMessage {
    private int x;
    private int y;
    private int z;
    private int value;
    private int type; // 0-speed,1-range

    public PacketUpdateTile() {
    }

    public PacketUpdateTile(int x, int y, int z, int value, int type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.value = value;
        this.type = type;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
        value = buf.readInt();
        type = buf.readByte();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeInt(value);
        buf.writeByte(type);
    }

    public static class Handler implements IMessageHandler<PacketUpdateTile, IMessage> {
        @Override
        public IMessage onMessage(PacketUpdateTile message, MessageContext ctx) {
            World world = ctx.getServerHandler().playerEntity.worldObj;
            TileEntity te = world.getTileEntity(message.x, message.y, message.z);
            if (te instanceof TileEntityBaseTimeCrystal crystal) {
                if (message.type == 0) {
                    crystal.setSpeedWithIndex(message.value);
                } else {
                    crystal.setRange(message.value);
                }
                crystal.markDirty();
                world.markBlockForUpdate(message.x, message.y, message.z);
            }
            return null;
        }
    }
}
