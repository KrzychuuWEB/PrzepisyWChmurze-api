package pl.przepisywchmurze.recipe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.przepisywchmurze.recipe.vo.RecipeSlug;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenerateUniqueSlugUseCaseTest {

    @Mock
    private CheckSlugUniquenessUseCase checkSlugUniquenessUseCase;

    @InjectMocks
    private GenerateUniqueSlugUseCase useCase;

    @Test
    void should_return_slug_when_it_is_unique() {
        RecipeSlug recipeSlug = new RecipeSlug("example-slug");
        when(checkSlugUniquenessUseCase.execute(recipeSlug)).thenReturn(true);

        RecipeSlug result = useCase.execute(recipeSlug);

        assertThat(result.value()).isEqualTo(recipeSlug.value());
        verify(checkSlugUniquenessUseCase).execute(recipeSlug);
        verifyNoMoreInteractions(checkSlugUniquenessUseCase);
    }

    @Test
    void should_return_slug_with_suffix_when_original_is_taken() {
        RecipeSlug existSlug = new RecipeSlug("example-slug");
        RecipeSlug freeSlug = new RecipeSlug("example-slug-2");
        when(checkSlugUniquenessUseCase.execute(existSlug)).thenReturn(false);
        when(checkSlugUniquenessUseCase.execute(freeSlug)).thenReturn(true);

        RecipeSlug result = useCase.execute(existSlug);

        assertThat(result.value()).isEqualTo("example-slug-2");
        verify(checkSlugUniquenessUseCase, times(1)).execute(existSlug);
        verify(checkSlugUniquenessUseCase, times(1)).execute(freeSlug);
        verifyNoMoreInteractions(checkSlugUniquenessUseCase);
    }
}