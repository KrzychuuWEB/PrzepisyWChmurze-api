package pl.przepisywchmurze.recipe;

class RecipeFactory {

    Recipe create(final RecipeAttributes attributes) {
        return Recipe.restore(new RecipeSnapshot(
                attributes.id(),
                attributes.slug(),
                attributes.title(),
                attributes.description(),
                attributes.servings(),
                attributes.prepTime(),
                attributes.cookTime()
        ));
    }
}
