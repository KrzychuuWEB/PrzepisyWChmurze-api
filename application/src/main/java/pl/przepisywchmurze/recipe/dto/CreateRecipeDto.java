package pl.przepisywchmurze.recipe.dto;

import jakarta.validation.constraints.*;

public record CreateRecipeDto(
        @NotBlank(message = "Title must not be blank")
        @Size(max = 100, message = "Title must not exceed 100 characters")
        String title,

        @Size(max = 1000, message = "Description must not exceed 1000 characters")
        @Pattern(
                regexp = "^(?!.*<[^>]+>).*",
                message = "Description must not contain HTML"
        )
        String description,

        @Min(value = 1, message = "Servings must be at least 1")
        @Max(value = 10, message = "Servings must not exceed 10")
        int servings,

        @Min(value = 1, message = "Preparation time must be at least 1 minute")
        int prepTime,

        @Min(value = 1, message = "Cooking time must be at least 1 minute")
        int cookTime

) {
}
