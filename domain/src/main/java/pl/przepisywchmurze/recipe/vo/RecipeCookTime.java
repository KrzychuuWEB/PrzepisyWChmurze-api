package pl.przepisywchmurze.recipe.vo;

public record RecipeCookTime(int value) {

    public static final int MIN = 1;
    public static final int MAX = 1440;

    public RecipeCookTime {
        if (value < MIN) {
            throw new IllegalArgumentException("Cook time must be at least " + MIN + " minute");
        }
        if (value > MAX) {
            throw new IllegalArgumentException("Cook time cannot be longer than " + MAX + " minutes");
        }
    }
}
