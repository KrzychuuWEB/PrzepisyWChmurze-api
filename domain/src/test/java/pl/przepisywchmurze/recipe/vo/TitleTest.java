package pl.przepisywchmurze.recipe.vo;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TitleTest {

    private final Faker faker = new Faker();

    @Test
    void should_return_correct_title() {
        String recipeTitle = faker.food().dish();
        Title title = new Title(recipeTitle);

        assertThat(title.value()).isEqualTo(recipeTitle);
    }

    @Test
    void should_return_exception_if_title_is_null() {
        assertThatThrownBy(() -> new Title(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Title cannot be null or blank");
    }

    @Test
    void should_return_exception_if_title_is_blank() {
        assertThatThrownBy(() -> new Title(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Title cannot be null or blank");
    }

    @Test
    void should_return_exception_if_title_is_too_long() {
        assertThatThrownBy(() -> new Title(faker.lorem().characters(Title.MAX_LENGTH + 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Title cannot be longer than " + Title.MAX_LENGTH + " characters");
    }
}