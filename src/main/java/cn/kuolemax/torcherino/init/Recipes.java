package cn.kuolemax.torcherino.init;

import cn.kuolemax.torcherino.Config;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public final class Recipes {
    public static void init() {
        if (!Config.overPoweredRecipe)
            GameRegistry.addRecipe(new ItemStack(ModBlocks.torcherino), "XCX", "CTC", "XCX", 'C', Items.clock, 'T', Blocks.torch);
        else
            GameRegistry.addRecipe(new ItemStack(ModBlocks.torcherino), "SCS", "CTC", "SCS", 'C', Items.clock, 'S', Items.nether_star, 'T', Blocks.torch);

        GameRegistry.addRecipe(new ItemStack(ModBlocks.compressedTorch), "XXX", "XXX", "XXX", 'X', ModBlocks.torcherino);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.doubleCompressedTorch), "XXX", "XXX", "XXX", 'X', ModBlocks.compressedTorch);
    }

    private Recipes() {
    }
}
