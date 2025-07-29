package pl.przepisywchmurze.recipe;

import pl.przepisywchmurze.recipe.vo.RecipeSlug;

class GenerateUniqueSlugUseCase {

    private final CheckSlugUniquenessUseCase checkSlugUniquenessUseCase;

    GenerateUniqueSlugUseCase(final CheckSlugUniquenessUseCase checkSlugUniquenessUseCase) {
        this.checkSlugUniquenessUseCase = checkSlugUniquenessUseCase;
    }

    RecipeSlug execute(final RecipeSlug slug) {
        if (checkSlugUniquenessUseCase.execute(slug)) {
            return slug;
        }

        int counter = 2;
        while (true) {
            RecipeSlug newSlug = new RecipeSlug(slug.value() + "-" + counter);
            if (checkSlugUniquenessUseCase.execute(newSlug)) {
                return newSlug;
            }
            counter++;
        }
    }
}

