package pl.przepisywchmurze.recipe.vo;

public record Title(String value) {
    static final int MAX_LENGTH = 100;

    public Title {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Title cannot be longer than " + MAX_LENGTH + " characters");
        }
    }
}
