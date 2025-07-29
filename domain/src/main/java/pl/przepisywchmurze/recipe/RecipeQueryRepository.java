package pl.przepisywchmurze.recipe;

import pl.przepisywchmurze.recipe.vo.RecipeSlug;

interface RecipeQueryRepository {

    Recipe getBySlug(final RecipeSlug recipeSlug);
}
