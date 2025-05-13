package cn.kuolemax.torcherino.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

public final class Recipes {
    public static void init(final Configuration cfg) {
        if (cfg.getBoolean("OverPoweredRecipe", "General", true, "Is the recipe for Torcherino extremely OP?"))
            GameRegistry.addRecipe(new ItemStack(ModBlocks.torcherino), "XCX", "CTC", "XCX", 'C', Items.clock, 'T', Blocks.torch);
        else
            GameRegistry.addRecipe(new ItemStack(ModBlocks.torcherino), "SCS", "CTC", "SCS", 'C', Items.clock, 'S', Items.nether_star, 'T', Blocks.torch);
    }

    private Recipes() {
    }
}
