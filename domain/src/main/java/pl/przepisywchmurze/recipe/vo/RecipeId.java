package pl.przepisywchmurze.recipe.vo;

public record RecipeId(Long value) {

    public RecipeId {
        if (value <= 0) {
            throw new IllegalArgumentException("Id cannot be less than 1");
        }
    }
}
