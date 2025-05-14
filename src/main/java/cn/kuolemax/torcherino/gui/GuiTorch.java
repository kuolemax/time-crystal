package cn.kuolemax.torcherino.gui;

import cn.kuolemax.torcherino.network.PacketHandler;
import cn.kuolemax.torcherino.network.PacketUpdateTile;
import cn.kuolemax.torcherino.tile.TileTorch;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GuiTorch extends GuiContainer {
    private final TileTorch tile;

    private final GuiButton[] speedButtons = new GuiButton[5]; // OFF + 4 levels
    private final GuiButton[] rangeButtons = new GuiButton[4]; // 4 range levels

    public GuiTorch(TileTorch tile, Container container) {
        super(container);
        this.tile = tile;
        this.xSize = 200;
        this.ySize = 120;
    }

    @Override
    public void initGui() {
        super.initGui();
        // Speed buttons
        int[] speeds = this.tile.getSpeeds();
        List<String> speedLabels = Arrays.stream(speeds).mapToObj(it -> it == 0 ? "OFF" : String.format("%s00%%", it)).collect(Collectors.toList());
        for (int i = 0; i < speedButtons.length; i++) {
            speedButtons[i] = new GuiButton(
                i,
                guiLeft + 10 + (i * 35),
                guiTop + 40,
                30, 20,
                speedLabels.get(i)
            );
            speedButtons[i].enabled = (i != tile.getSpeedIndex()); // 非当前选项可点击
            this.buttonList.add(speedButtons[i]);
        }

        // Range buttons
        String[] rangeLabels = {"3x3", "5x5", "7x7", "9x9"};
        for (int i = 0; i < rangeButtons.length; i++) {
            rangeButtons[i] = new GuiButton(
                i + 10, // 使用不同ID范围
                guiLeft + 10 + (i * 45),
                guiTop + 80,
                40, 20,
                rangeLabels[i]
            );
            rangeButtons[i].enabled = (i + 1 != tile.getRange()); // 范围值从1开始
            this.buttonList.add(rangeButtons[i]);
        }
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        // 处理速度按钮 (ID 0-4)
        if (button.id >= 0 && button.id <= 4) {
            tile.setSpeedWithIndex(button.id);

            // 更新按钮状态
            for (int i = 0; i < speedButtons.length; i++) {
                speedButtons[i].enabled = (i != button.id);
            }

            // 发送数据包
            PacketHandler.INSTANCE.sendToServer(new PacketUpdateTile(
                tile.xCoord, tile.yCoord, tile.zCoord,
                button.id, 0 // 0 for speed
            ));
        }
        // 处理范围按钮 (ID 10-13)
        else if (button.id >= 10 && button.id <= 13) {
            int rangeValue = button.id - 9; // 转换为1-4
            tile.setRange(rangeValue);

            // 更新按钮状态
            for (int i = 0; i < rangeButtons.length; i++) {
                rangeButtons[i].enabled = (i + 1 != rangeValue);
            }

            // 发送数据包
            PacketHandler.INSTANCE.sendToServer(new PacketUpdateTile(
                tile.xCoord, tile.yCoord, tile.zCoord,
                rangeValue, 1 // 1 for range
            ));
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        drawDefaultBackground();
        mc.getTextureManager().bindTexture(new ResourceLocation("torcherino:textures/gui/torch_gui.png"));
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        // 绘制物品名称（使用本地化）
        fontRendererObj.drawString(this.tile.getBlockType().getLocalizedName(), guiLeft + 8, guiTop + 6, 0x404040);

        // 绘制设置标题（使用本地化）
        String speedText = StatCollector.translateToLocal("gui.torcherino.speed");
        String rangeText = StatCollector.translateToLocal("gui.torcherino.range");

        fontRendererObj.drawString(speedText, guiLeft + 10, guiTop + 30, 0x404040);
        fontRendererObj.drawString(rangeText, guiLeft + 10, guiTop + 70, 0x404040);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        // 确保文字不会被背景覆盖
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_BLEND);
    }
}
