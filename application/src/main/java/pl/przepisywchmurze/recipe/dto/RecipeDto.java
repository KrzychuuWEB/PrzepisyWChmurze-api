package pl.przepisywchmurze.recipe.dto;

import pl.przepisywchmurze.recipe.vo.*;

public record RecipeDto(
        RecipeSlug slug,
        Title title,
        Description description,
        RecipeServings servings,
        RecipePrepTime prepTime,
        RecipeCookTime cookTime
) {
}
