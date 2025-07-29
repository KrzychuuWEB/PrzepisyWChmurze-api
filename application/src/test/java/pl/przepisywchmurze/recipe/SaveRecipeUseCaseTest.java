package pl.przepisywchmurze.recipe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SaveRecipeUseCaseTest {

    @Mock
    private RecipeRepository recipeRepository;

    @Mock
    private RecipeFacade recipeFacade;

    @Mock
    private GenerateUniqueSlugUseCase generateUniqueSlugUseCase;

    @InjectMocks
    private SaveRecipeUseCase useCase;

    @Test
    void should_create_and_save_recipe_with_generated_slug() {
    }

}