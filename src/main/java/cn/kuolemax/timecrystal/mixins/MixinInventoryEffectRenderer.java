package cn.kuolemax.timecrystal.mixins;

import cn.kuolemax.timecrystal.Config;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Collection;

@Mixin(InventoryEffectRenderer.class)
public abstract class MixinInventoryEffectRenderer {

    /**
     * 重定向原代码里对 activePotionEffects.isEmpty() 的调用，
     * 使其始终返回 true，从而跳过 GUI 布局调整分支。
     */
    @Redirect(
        method = "initGui",
        at = @At(
            value = "INVOKE",
            target = "Ljava/util/Collection;isEmpty()Z"
        )
    )
    private boolean alwaysEmpty(Collection<?> potionEffects) {
        // 无论实际情况如何，都让它认为“药水列表是空的”
        if (Config.hidePotionEffects) {
            return true;
        }
        return potionEffects.isEmpty();
    }

}
