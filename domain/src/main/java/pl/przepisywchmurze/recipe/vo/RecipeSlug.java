package pl.przepisywchmurze.recipe.vo;

import java.text.Normalizer;
import java.util.Objects;

public record RecipeSlug(String value) {
    private static final String HTML_TAGS_PATTERN = "<[^>]*>";
    private static final String DIACRITICS_PATTERN = "\\p{InCombiningDiacriticalMarks}+";
    private static final String SPECIAL_CHARS_PATTERN = "[^\\p{Alnum}\\s-]";
    private static final String MULTIPLE_SPACES_PATTERN = "\\s+";
    private static final String MULTIPLE_HYPHENS_PATTERN = "-{2,}";
    private static final String LEADING_TRAILING_HYPHENS_PATTERN = "^-+|-+$";

    public RecipeSlug {
        Objects.requireNonNull(value, "Slug cannot be null");
        String normalizedValue = normalize(value);
        if (normalizedValue.isBlank()) {
            throw new IllegalArgumentException("Slug cannot be blank");
        }
        value = normalizedValue;
    }

    private static String normalize(String input) {
        return replaceDiacritics(input)
                .transform(RecipeSlug::removeHtmlTags)
                .toLowerCase()
                .transform(RecipeSlug::removeSpecialCharacters)
                .transform(RecipeSlug::convertSpacesToHyphens)
                .transform(RecipeSlug::cleanupHyphens);
    }

    private static String replaceDiacritics(String input) {
        String withoutPolishChars = input.replace('ł', 'l').replace('Ł', 'L');
        return Normalizer.normalize(withoutPolishChars, Normalizer.Form.NFD)
                .replaceAll(DIACRITICS_PATTERN, "");
    }

    private static String removeHtmlTags(String input) {
        return input.replaceAll(HTML_TAGS_PATTERN, "");
    }

    private static String removeSpecialCharacters(String input) {
        return input.replaceAll(SPECIAL_CHARS_PATTERN, "");
    }

    private static String convertSpacesToHyphens(String input) {
        return input.trim().replaceAll(MULTIPLE_SPACES_PATTERN, "-");
    }

    private static String cleanupHyphens(String input) {
        return input.replaceAll(MULTIPLE_HYPHENS_PATTERN, "-")
                .replaceAll(LEADING_TRAILING_HYPHENS_PATTERN, "");
    }
}