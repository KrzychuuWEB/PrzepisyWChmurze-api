package pl.przepisywchmurze.recipe.vo;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DescriptionTest {

    private final Faker faker = new Faker();

    @Test
    void should_return_correct_description() {
        String example = faker.food().allergen();
        Description description = new Description(example);

        assertThat(description.value()).isEqualTo(example);
    }

    @Test
    void should_return_exception_if_description_is_too_long() {
        assertThatThrownBy(() -> new Description(faker.lorem().characters(Description.MAX_LENGTH + 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Description cannot be longer than " + Description.MAX_LENGTH + " characters");
    }

    @Test
    void should_return_exception_if_description_has_html() {
        assertThatThrownBy(() -> new Description("<p>description</p>"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Description cannot contain HTML");
    }
}