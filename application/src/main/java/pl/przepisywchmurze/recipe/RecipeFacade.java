package pl.przepisywchmurze.recipe;

import pl.przepisywchmurze.recipe.command.SaveRecipeCommand;
import pl.przepisywchmurze.recipe.dto.CreateRecipeDto;
import pl.przepisywchmurze.recipe.dto.RecipeDto;
import pl.przepisywchmurze.recipe.vo.*;

public class RecipeFacade {

    private final SaveRecipeUseCase saveRecipeUseCase;

    RecipeFacade(final SaveRecipeUseCase saveRecipeUseCase) {
        this.saveRecipeUseCase = saveRecipeUseCase;
    }

    RecipeDto save(final CreateRecipeDto dto) {
        SaveRecipeCommand command = new SaveRecipeCommand(
                new Title(dto.title()),
                new Description(dto.description()),
                new RecipeServings(dto.servings()),
                new RecipePrepTime(dto.prepTime()),
                new RecipeCookTime(dto.cookTime())
        );

        return RecipeMapper.mapToRecipeDto(saveRecipeUseCase.execute(command));
    }
}
