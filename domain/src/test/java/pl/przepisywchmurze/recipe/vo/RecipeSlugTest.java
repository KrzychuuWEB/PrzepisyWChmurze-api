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
                .hasMessage("Slug cannot be blank");
    }

    @Test
    void should_return_exception_when_slug_is_null() {
        assertThatThrownBy(() -> new RecipeSlug(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Slug cannot be null");
    }

    @Test
    void should_remove_html_tags() {
        RecipeSlug slug = new RecipeSlug("<p>Curry chicken</p>");

        assertThat(slug.value()).isEqualTo("curry-chicken");
    }

    @Test
    void should_remove_diacritics() {
        RecipeSlug slug = new RecipeSlug("Żurek z kiełbasą");

        assertThat(slug.value()).isEqualTo("zurek-z-kielbasa");
    }

    @Test
    void should_remove_special_characters_and_emojis() {
        RecipeSlug slug = new RecipeSlug("Pasta \uD83C\uDF5D & Wine!");

        assertThat(slug.value()).isEqualTo("pasta-wine");
    }

    @Test
    void should_replace_multiple_whitespaces_with_single_hyphen() {
        RecipeSlug slug = new RecipeSlug("Big    burger    ");

        assertThat(slug.value()).isEqualTo("big-burger");
    }

    @Test
    void should_collapse_multiple_hyphens() {
        RecipeSlug slug = new RecipeSlug("Big------burger");

        assertThat(slug.value()).isEqualTo("big-burger");
    }

    @Test
    void should_remove_leading_and_trailing_hyphens() {
        RecipeSlug slug = new RecipeSlug("----Big------burger---");

        assertThat(slug.value()).isEqualTo("big-burger");
    }

    @Test
    void should_return_slug_in_lowercase() {
        RecipeSlug slug = new RecipeSlug("BIG BURGER");

        assertThat(slug.value()).isEqualTo("big-burger");
    }

    @Test
    void should_return_exception_when_result_is_only_special_characters() {
        assertThatThrownBy(() -> new RecipeSlug("!!!###"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Slug cannot be blank");
    }
}