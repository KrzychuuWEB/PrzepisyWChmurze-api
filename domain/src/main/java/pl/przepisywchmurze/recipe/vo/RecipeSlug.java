package pl.przepisywchmurze.recipe.vo;

import java.text.Normalizer;
import java.util.Objects;

public record RecipeSlug(String value) {
    public RecipeSlug {
        Objects.requireNonNull(value, "Slug cannot be null");
        String normalized = normalize(value);
        if (normalized.isBlank()) {
            throw new IllegalArgumentException("Slug cannot be blank");
        }
        value = normalized;
    }

    private static String normalize(String input) {
        input = input.replace('ł', 'l').replace('Ł', 'L');
        String result = input.replaceAll("<[^>]*>", "");

        result = result.toLowerCase();

        result = Normalizer.normalize(result, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        result = result.replaceAll("[^\\p{Alnum}\\s-]", "");

        result = result.trim().replaceAll("\\s+", "-");

        result = result.replaceAll("-{2,}", "-");

        result = result.replaceAll("^-+|-+$", "");

        return result;
    }

}
