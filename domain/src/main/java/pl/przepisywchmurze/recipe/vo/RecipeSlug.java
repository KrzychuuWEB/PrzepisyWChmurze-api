package pl.przepisywchmurze.recipe.vo;

public record RecipeSlug(String value) {
    public RecipeSlug {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Slug cannot be null or blank");
        }
        value = normalize(value);
    }

    private static String normalize(String input) {
        return input.trim().toLowerCase().replaceAll("\\s+", "-");
    }
}
