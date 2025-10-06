package cn.kuolemax.timecrystal.init;

import cn.kuolemax.timecrystal.Config;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public final class Recipes {
    public static void init() {
        if (Config.overPoweredRecipe)
            GameRegistry.addRecipe(new ItemStack(ModBlocks.timeCrystal), "XCX", "CTC", "XCX", 'C', Items.clock, 'T', Items.nether_star);
        else
            GameRegistry.addRecipe(new ItemStack(ModBlocks.timeCrystal), "SCS", "CTC", "SCS", 'C', Items.clock, 'S', Blocks.diamond_block, 'T', Items.nether_star);

        GameRegistry.addRecipe(new ItemStack(ModBlocks.compressedTimeCrystal), "XXX", "XXX", "XXX", 'X', ModBlocks.timeCrystal);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.doubleCompressedTimeCrystal), "XXX", "XXX", "XXX", 'X', ModBlocks.compressedTimeCrystal);
    }

    private Recipes() {
    }
}
