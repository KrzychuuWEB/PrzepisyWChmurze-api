package pl.przepisywchmurze.recipe;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RecipeTest {

    @Test
    void should_restore_recipe_from_snapshot() {
        RecipeSnapshot recipeSnapshot = RecipeSnapshotMother.builder().build();

        Recipe recipe = Recipe.restore(recipeSnapshot);

        assertThat(recipe.getSnapshot().recipeId()).isEqualTo(RecipeSnapshotMother.DEFAULT_RECIPE_ID);
        assertThat(recipe.getSnapshot().slug()).isEqualTo(RecipeSnapshotMother.DEFAULT_SLUG);
        assertThat(recipe.getSnapshot().description()).isEqualTo(RecipeSnapshotMother.DEFAULT_DESCRIPTION);
    }
}