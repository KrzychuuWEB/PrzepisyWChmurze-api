package pl.przepisywchmurze.recipe;

import pl.przepisywchmurze.recipe.vo.*;

record RecipeSnapshot(
        RecipeId recipeId,
        RecipeSlug slug,
        Title title,
        Description description,
        RecipeServings servings,
        RecipePrepTime prepTime,
        RecipeCookTime cookTime
) {
}
