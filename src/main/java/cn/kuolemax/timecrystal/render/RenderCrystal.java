package cn.kuolemax.timecrystal.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cn.kuolemax.timecrystal.block.BlockTimeCrystal;
import cn.kuolemax.timecrystal.model.ModelCrystal;
import cn.kuolemax.timecrystal.tile.TileEntityBaseTimeCrystal;
import cn.kuolemax.timecrystal.util.RenderUtils;

public class RenderCrystal extends TileEntitySpecialRenderer {

    private final ModelCrystal model = new ModelCrystal();

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        TileEntityBaseTimeCrystal tile = (TileEntityBaseTimeCrystal) te;
        BlockTimeCrystal block = (BlockTimeCrystal) tile.getBlockType();
        ResourceLocation tex = RenderUtils.getBlockTexture(block.getPublicTextureName());
        this.bindTexture(tex);

        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y + 1.5, z + 0.5); // 调整模型中心点
        GL11.glRotated(180, 0, 0, 1);
        model.render(null, 0, -0.1f, 0, 0, 0, 0.0625F);
        GL11.glPopMatrix();
    }
}
