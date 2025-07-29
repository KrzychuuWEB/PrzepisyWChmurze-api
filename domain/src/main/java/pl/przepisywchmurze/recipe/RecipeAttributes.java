package pl.przepisywchmurze.recipe;

import pl.przepisywchmurze.recipe.vo.*;

record RecipeAttributes(
        RecipeId id,
        RecipeSlug slug,
        Title title,
        Description description,
        RecipeServings servings,
        RecipePrepTime prepTime,
        RecipeCookTime cookTime
) {
}
