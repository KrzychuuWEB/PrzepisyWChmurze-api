package pl.przepisywchmurze.recipe.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RecipePrepTimeTest {

    @Test
    void should_create_prep_time_when_minutes_is_valid() {
        int examplePrepTime = 15;
        RecipePrepTime recipePrepTime = new RecipePrepTime(examplePrepTime);

        assertThat(recipePrepTime.value()).isEqualTo(examplePrepTime);
    }

    @Test
    void should_throw_exception_when_minutes_is_less_than_minimum() {
        assertThatThrownBy(() -> new RecipePrepTime(RecipePrepTime.MIN - 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Prep time must be at least " + RecipePrepTime.MIN + " minute");
    }

    @Test
    void should_create_prep_time_with_minimum_value() {
        RecipePrepTime recipePrepTime = new RecipePrepTime(RecipePrepTime.MIN);

        assertThat(recipePrepTime.value()).isEqualTo(RecipePrepTime.MIN);
    }
}