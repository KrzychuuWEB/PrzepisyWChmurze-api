package pl.przepisywchmurze.recipe.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RecipeServingsTest {

    @Test
    void should_create_servings_when_value_is_within_bounds() {
        int servings = RecipeServings.MIN + 1;
        RecipeServings recipeServings = new RecipeServings(servings);

        assertThat(recipeServings.value()).isEqualTo(servings);
    }

    @Test
    void should_throw_exception_when_value_is_below_minimum() {
        assertThatThrownBy(() -> new RecipeServings(RecipeServings.MIN - 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Servings must be at least " + RecipeServings.MIN);
    }

    @Test
    void should_throw_exception_when_value_is_above_maximum() {
        assertThatThrownBy(() -> new RecipeServings(RecipeServings.MAX + 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Servings cannot be greater than " + RecipeServings.MAX);
    }

    @Test
    void should_create_servings_with_minimum_value() {
        int min = RecipeServings.MIN;
        RecipeServings recipeServings = new RecipeServings(min);

        assertThat(recipeServings.value()).isEqualTo(min);
    }

    @Test
    void should_create_servings_with_maximum_value() {
        int max = RecipeServings.MAX;
        RecipeServings recipeServings = new RecipeServings(max);

        assertThat(recipeServings.value()).isEqualTo(max);
    }
}