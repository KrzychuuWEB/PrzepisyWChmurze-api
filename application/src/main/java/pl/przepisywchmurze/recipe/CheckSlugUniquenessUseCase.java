package pl.przepisywchmurze.recipe;

import pl.przepisywchmurze.recipe.vo.RecipeSlug;

class CheckSlugUniquenessUseCase {

    private final RecipeQueryRepository recipeQueryRepository;

    CheckSlugUniquenessUseCase(final RecipeQueryRepository recipeQueryRepository) {
        this.recipeQueryRepository = recipeQueryRepository;
    }

    boolean execute(final RecipeSlug slug) {
        return !recipeQueryRepository.existsBySlug(slug);
    }
}
