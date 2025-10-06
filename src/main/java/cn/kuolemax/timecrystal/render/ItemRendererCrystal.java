package cn.kuolemax.timecrystal.render;

import cn.kuolemax.timecrystal.block.BlockTimeCrystal;
import cn.kuolemax.timecrystal.model.ModelCrystal;
import cn.kuolemax.timecrystal.util.RenderUtils;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemRendererCrystal implements IItemRenderer {

    private final ModelCrystal model = new ModelCrystal();

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        // 所有类型都需要渲染（包括手持、物品栏、地上）
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

        BlockTimeCrystal block = (BlockTimeCrystal) Block.getBlockFromItem(item.getItem());
        ResourceLocation tex = RenderUtils.getBlockTexture(block.getPublicTextureName());
        Minecraft.getMinecraft().getTextureManager().bindTexture(tex);

        GL11.glPushMatrix();

        // 调整角度与位置
        // switch (type) {
        //     case EQUIPPED: // 第三人称
        //         GL11.glTranslatef(0.5F, 1.5F, 0.5F);
        //         break;
        //
        //     case EQUIPPED_FIRST_PERSON: // 第一人称
        //         GL11.glTranslatef(1.5F, 1.2F, 0.7F);
        //         break;
        //
        //     case INVENTORY: // 物品栏图标
        //         GL11.glTranslated(0.5, 1.5, 0.5); // 调整模型中心点
        //         GL11.glRotated(180, 0, 0, 1);
        //         break;
        //
        //     case ENTITY: // 地上掉落物
        //         GL11.glTranslatef(0F, 0.5F, 0F);
        //         break;
        // }

        GL11.glTranslated(0.5, 1.5, 0.5); // 调整模型中心点
        GL11.glRotated(180, 0, 0, 1);

        model.render(null, 0, -0.1f, 0, 0, 0, 0.0625F);
        GL11.glPopMatrix();
    }
}
