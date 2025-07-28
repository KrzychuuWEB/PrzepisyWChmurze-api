package pl.przepisywchmurze.recipe.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RecipeSlugTest {

    @Test
    void should_return_correct_slug_with_normalize() {
        RecipeSlug slug = new RecipeSlug("Salat with chicken");

        assertThat(slug.value()).isEqualTo("salat-with-chicken");
    }

    @Test
    void should_return_exception_when_slug_is_blank() {
        assertThatThrownBy(() -> new RecipeSlug(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Slug cannot be null or blank");
    }

    @Test
    void should_return_exception_when_slug_is_null() {
        assertThatThrownBy(() -> new RecipeSlug(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Slug cannot be null or blank");
    }
}