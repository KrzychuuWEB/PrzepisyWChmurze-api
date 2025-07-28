package pl.przepisywchmurze.recipe.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RecipeCookTimeTest {

    @Test
    void should_create_cook_time_when_value_is_within_bounds() {
        int cookingTime = RecipeCookTime.MIN + 1;
        RecipeCookTime recipeCookTime = new RecipeCookTime(cookingTime);

        assertThat(recipeCookTime.value()).isEqualTo(cookingTime);
    }

    @Test
    void should_throw_exception_when_value_is_below_minimum() {
        assertThatThrownBy(() -> new RecipeCookTime(RecipeCookTime.MIN - 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Cook time must be at least " + RecipeCookTime.MIN + " minute");
    }

    @Test
    void should_throw_exception_when_value_is_above_maximum() {
        assertThatThrownBy(() -> new RecipeCookTime(RecipeCookTime.MAX + 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Cook time cannot be longer than " + RecipeCookTime.MAX + " minutes");
    }

    @Test
    void should_create_cook_time_with_minimum_value() {
        RecipeCookTime recipeCookTime = new RecipeCookTime(RecipeCookTime.MIN);

        assertThat(recipeCookTime.value()).isEqualTo(RecipeCookTime.MIN);
    }

    @Test
    void should_create_cook_time_with_maximum_value() {
        RecipeCookTime recipeCookTime = new RecipeCookTime(RecipeCookTime.MAX);

        assertThat(recipeCookTime.value()).isEqualTo(RecipeCookTime.MAX);
    }
}