package pl.przepisywchmurze.recipe;

import pl.przepisywchmurze.recipe.command.SaveRecipeCommand;
import pl.przepisywchmurze.recipe.vo.RecipeId;
import pl.przepisywchmurze.recipe.vo.RecipeSlug;

class SaveRecipeUseCase {

    private final RecipeRepository recipeRepository;
    private final RecipeFactory recipeFactory;
    private final GenerateUniqueSlugUseCase generateUniqueSlugUseCase;

    SaveRecipeUseCase(
            final RecipeRepository recipeRepository,
            final RecipeFactory recipeFactory,
            final GenerateUniqueSlugUseCase generateUniqueSlugUseCase
    ) {
        this.recipeRepository = recipeRepository;
        this.recipeFactory = recipeFactory;
        this.generateUniqueSlugUseCase = generateUniqueSlugUseCase;
    }

    Recipe execute(final SaveRecipeCommand command) {
        RecipeSlug slug = generateUniqueSlugUseCase.execute(new RecipeSlug(command.title().value()));

        return recipeRepository.save(
                recipeFactory.create(new RecipeAttributes(
                        new RecipeId(null),
                        slug,
                        command.title(),
                        command.description(),
                        command.servings(),
                        command.prepTime(),
                        command.cookTime()
                ))
        );
    }
}
