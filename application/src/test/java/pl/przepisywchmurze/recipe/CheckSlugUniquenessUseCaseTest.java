package pl.przepisywchmurze.recipe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.przepisywchmurze.recipe.vo.RecipeSlug;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CheckSlugUniquenessUseCaseTest {

    @Mock
    private RecipeQueryRepository recipeQueryRepository;

    @InjectMocks
    private CheckSlugUniquenessUseCase useCase;

    @Test
    void should_return_true_when_slug_is_unique() {
        RecipeSlug slug = new RecipeSlug("not-unique-slug");
        when(recipeQueryRepository.existsBySlug(slug)).thenReturn(true);

        boolean result = useCase.execute(slug);

        assertThat(result).isFalse();
        verify(recipeQueryRepository).existsBySlug(slug);
    }

    @Test
    void should_return_false_when_slug_already_exists() {
        RecipeSlug slug = new RecipeSlug("unique-slug");
        when(recipeQueryRepository.existsBySlug(slug)).thenReturn(false);

        boolean result = useCase.execute(slug);

        assertThat(result).isTrue();
        verify(recipeQueryRepository).existsBySlug(slug);
    }
}