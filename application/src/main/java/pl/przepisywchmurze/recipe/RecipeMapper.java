package pl.przepisywchmurze.recipe;

import pl.przepisywchmurze.recipe.dto.RecipeDto;

final class RecipeMapper {

    private RecipeMapper() {
    }

    static RecipeDto mapToRecipeDto(final Recipe recipe) {
        return new RecipeDto(
                recipe.getSnapshot().slug(),
                recipe.getSnapshot().title(),
                recipe.getSnapshot().description(),
                recipe.getSnapshot().servings(),
                recipe.getSnapshot().prepTime(),
                recipe.getSnapshot().cookTime()
        );
    }
}
