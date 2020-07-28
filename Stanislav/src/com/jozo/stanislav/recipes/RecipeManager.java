package com.jozo.stanislav.recipes;
import com.jozo.stanislav.Stanislav;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.FurnaceRecipe;

public class RecipeManager {

    public static void loadRecipes(){
        StoneBricks();
        Diamond();
    }

    private static void StoneBricks(){
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("multiply_stone_bricks"), new ItemStack(Material.STONE_BRICKS, 6));
        recipe.shape("   ",
                     "BI ",
                     "IB ");
        recipe.setIngredient('B', Material.STONE_BRICKS);
        recipe.setIngredient('I', Material.IRON_INGOT);
        Stanislav.main.getServer().addRecipe(recipe);
    }

    private static void Diamond(){
        FurnaceRecipe recipe = new FurnaceRecipe(NamespacedKey.minecraft("craft_diamond"), new ItemStack(Material.DIAMOND, 1),
                Material.COAL, 2.5f, 60 * 20);
        Stanislav.main.getServer().addRecipe(recipe);
    }

}
