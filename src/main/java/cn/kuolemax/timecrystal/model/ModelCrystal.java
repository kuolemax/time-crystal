package cn.kuolemax.timecrystal.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * crystal - kuolemax
 * Created using Tabula 4.1.1
 */
public class ModelCrystal extends ModelBase {
    public ModelRenderer shape1;

    public ModelCrystal() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.shape1.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
        this.setRotateAngle(shape1, 0.7853981633974483F, 0.7853981633974483F, 0.7853981633974483F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape1.offsetX, this.shape1.offsetY, this.shape1.offsetZ);
        GL11.glTranslatef(this.shape1.rotationPointX * f5, this.shape1.rotationPointY * f5, this.shape1.rotationPointZ * f5);
        GL11.glScaled(0.6D, 0.6D, 0.6D);
        GL11.glTranslatef(-this.shape1.offsetX, -this.shape1.offsetY, -this.shape1.offsetZ);
        GL11.glTranslatef(-this.shape1.rotationPointX * f5, -this.shape1.rotationPointY * f5, -this.shape1.rotationPointZ * f5);
        this.shape1.render(f5);
        GL11.glPopMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
