package pl.przepisywchmurze.recipe;

import pl.przepisywchmurze.recipe.vo.*;

class Recipe {

    static Recipe restore(RecipeSnapshot snapshot) {
        return new Recipe(
                snapshot.recipeId(),
                snapshot.slug(),
                snapshot.title(),
                snapshot.description(),
                snapshot.servings(),
                snapshot.prepTime(),
                snapshot.cookTime()
        );
    }

    private final RecipeId recipeId;
    private final RecipeSlug slug;
    private final Title title;
    private final Description description;
    private final RecipeServings servings;
    private final RecipePrepTime prepTime;
    private final RecipeCookTime cookTime;

    private Recipe(final RecipeId recipeId,
                   final RecipeSlug slug,
                   final Title title,
                   final Description description,
                   final RecipeServings servings,
                   final RecipePrepTime prepTime,
                   final RecipeCookTime cookTime
    ) {
        this.recipeId = recipeId;
        this.slug = slug;
        this.title = title;
        this.description = description;
        this.servings = servings;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
    }

    RecipeSnapshot getSnapshot() {
        return new RecipeSnapshot(
                recipeId,
                slug,
                title,
                description,
                servings,
                prepTime,
                cookTime
        );
    }
}
