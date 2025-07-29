package pl.przepisywchmurze.recipe.command;

import pl.przepisywchmurze.recipe.vo.*;

public record SaveRecipeCommand(
        Title title,
        Description description,
        RecipeServings servings,
        RecipePrepTime prepTime,
        RecipeCookTime cookTime
) {
}
