package pl.przepisywchmurze.recipe;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.przepisywchmurze.recipe.command.SaveRecipeCommand;
import pl.przepisywchmurze.recipe.vo.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SaveRecipeUseCaseTest {

    private Faker faker = new Faker();

    @Mock
    private RecipeRepository recipeRepository;

    @Mock
    private RecipeFactory recipeFactory;

    @Mock
    private GenerateUniqueSlugUseCase generateUniqueSlugUseCase;

    @InjectMocks
    private SaveRecipeUseCase useCase;

    @Test
    void should_create_and_save_recipe_with_generated_slug() {
        SaveRecipeCommand saveRecipeCommand = new SaveRecipeCommand(
                new Title("Big Burger With Cheese"),
                new Description(faker.food().dish()),
                new RecipeServings(1),
                new RecipePrepTime(2),
                new RecipeCookTime(3)
        );
        Recipe recipe = Recipe.restore(RecipeSnapshotMother
                .builder()
                .withRecipeId(new RecipeId(2L))
                .withTitle(new Title(faker.food().dish()))
                .withSlug(new RecipeSlug("big-burger-with-cheese"))
                .build());

        when(generateUniqueSlugUseCase.execute(any(RecipeSlug.class))).thenReturn(recipe.getSnapshot().slug());
        when(recipeFactory.create(any(RecipeAttributes.class))).thenReturn(recipe);
        when(recipeRepository.save(any(Recipe.class))).thenReturn(recipe);

        Recipe result = useCase.execute(saveRecipeCommand);

        assertThat(result.getSnapshot().slug().value()).isEqualTo(recipe.getSnapshot().slug().value());
        assertThat(result.getSnapshot().title().value()).isEqualTo(recipe.getSnapshot().title().value());
        verify(generateUniqueSlugUseCase).execute(any(RecipeSlug.class));
        verify(recipeFactory).create(any(RecipeAttributes.class));
        verify(recipeRepository).save(any(Recipe.class));
    }
}