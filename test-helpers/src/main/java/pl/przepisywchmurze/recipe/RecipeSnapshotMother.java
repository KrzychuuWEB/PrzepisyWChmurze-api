package pl.przepisywchmurze.recipe;

import net.datafaker.Faker;
import pl.przepisywchmurze.recipe.vo.*;

public final class RecipeSnapshotMother {

    private static final Faker faker = new Faker();

    public static final RecipeId DEFAULT_RECIPE_ID = new RecipeId(1L);
    public static final RecipeSlug DEFAULT_SLUG = new RecipeSlug("example-slug");
    public static final Title DEFAULT_TITLE = new Title(faker.food().dish());
    public static final Description DEFAULT_DESCRIPTION = new Description(faker.food().measurement());
    public static final RecipeServings DEFAULT_SERVINGS = new RecipeServings(2);
    public static final RecipePrepTime DEFAULT_PREP_TIME = new RecipePrepTime(15);
    public static final RecipeCookTime DEFAULT_COOK_TIME = new RecipeCookTime(30);

    static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private RecipeId recipeId = DEFAULT_RECIPE_ID;
        private RecipeSlug slug = DEFAULT_SLUG;
        private Title title = DEFAULT_TITLE;
        private Description description = DEFAULT_DESCRIPTION;
        private RecipeServings servings = DEFAULT_SERVINGS;
        private RecipePrepTime prepTime = DEFAULT_PREP_TIME;
        private RecipeCookTime cookTime = DEFAULT_COOK_TIME;

        public Builder withRecipeId(RecipeId id) {
            this.recipeId = id;
            return this;
        }

        public Builder withSlug(RecipeSlug slug) {
            this.slug = slug;
            return this;
        }

        public Builder withTitle(Title title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(Description description) {
            this.description = description;
            return this;
        }

        public Builder withServings(RecipeServings servings) {
            this.servings = servings;
            return this;
        }

        public Builder withPrepTime(RecipePrepTime prepTime) {
            this.prepTime = prepTime;
            return this;
        }

        public Builder withCookTime(RecipeCookTime cookTime) {
            this.cookTime = cookTime;
            return this;
        }

        RecipeSnapshot build() {
            return new RecipeSnapshot(recipeId, slug, title, description, servings, prepTime, cookTime);
        }
    }
}
