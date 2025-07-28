package pl.przepisywchmurze.recipe.vo;

public record Description(String value) {

    static final int MAX_LENGTH = 1000;

    public Description {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Description cannot be longer than " + MAX_LENGTH + " characters");
        }

        if (containsHtml(value)) {
            throw new IllegalArgumentException("Description cannot contain HTML");
        }
    }

    private static boolean containsHtml(String input) {
        return input.matches(".*<[^>]+>.*");
    }
}
