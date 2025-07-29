package pl.przepisywchmurze.recipe;

import pl.przepisywchmurze.recipe.command.SaveRecipeCommand;
import pl.przepisywchmurze.recipe.vo.RecipeId;
import pl.przepisywchmurze.recipe.vo.RecipeSlug;

class SaveRecipeUseCase {

    private final RecipeRepository recipeRepository;
    private final RecipeFactory recipeFactory;

    SaveRecipeUseCase(
            final RecipeRepository recipeRepository,
            final RecipeFactory recipeFactory
    ) {
        this.recipeRepository = recipeRepository;
        this.recipeFactory = recipeFactory;
    }

    Recipe execute(final SaveRecipeCommand command) {
        return recipeRepository.save(
                recipeFactory.create(new RecipeAttributes(
                        new RecipeId(null),
                        new RecipeSlug(command.title().value()),
                        command.title(),
                        command.description(),
                        command.servings(),
                        command.prepTime(),
                        command.cookTime()
                ))
        );
    }
}
