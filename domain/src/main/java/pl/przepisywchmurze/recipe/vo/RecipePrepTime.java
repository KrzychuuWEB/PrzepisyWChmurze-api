package pl.przepisywchmurze.recipe.vo;

public record RecipePrepTime(int value) {

    public static final int MIN = 1;

    public RecipePrepTime {
        if (value < MIN) {
            throw new IllegalArgumentException("Prep time must be at least " + MIN + " minute");
        }
    }
}
