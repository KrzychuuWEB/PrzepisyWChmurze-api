package pl.przepisywchmurze.recipe.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RecipeIdTest {

    @Test
    void should_return_correct_recipe_id() {
        Long id = 1L;
        RecipeId recipeId = new RecipeId(id);

        assertThat(recipeId.value()).isEqualTo(id);
    }

    @Test
    void should_return_exception_if_id_is_less_1() {
        assertThatThrownBy(() -> new RecipeId(-1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Id cannot be less than 1");
    }
}