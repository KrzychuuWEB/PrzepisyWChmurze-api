package pl.przepisywchmurze.recipe.vo;

public record RecipeServings(int value) {

    public static final int MIN = 1;
    public static final int MAX = 10;

    public RecipeServings {
        if (value < MIN) {
            throw new IllegalArgumentException("Servings must be at least " + MIN);
        }
        if (value > MAX) {
            throw new IllegalArgumentException("Servings cannot be greater than " + MAX);
        }
    }
}
