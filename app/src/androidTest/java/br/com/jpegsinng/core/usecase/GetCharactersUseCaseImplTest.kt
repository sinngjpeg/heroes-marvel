package br.com.jpegsinng.core.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import br.com.jpegsinng.core.data.repository.CharactersRepository
import br.com.jpegsinng.testing.MainCoroutineRules
import br.com.jpegsinng.testing.model.CharacterFactory
import br.com.jpegsinng.testing.pagingsource.PagingSourceFactory
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetCharactersUseCaseImplTest{

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRules()

    @Mock
    lateinit var repository: CharactersRepository

    private lateinit var getCharactersUseCase: GetCharactersUseCase

    private val hero = CharacterFactory().create(CharacterFactory.Hero.ThreeDMan)

    private val fakePagingSource = PagingSourceFactory().create(listOf(hero))

    @Before
    fun setup() {
        getCharactersUseCase = GetCharactersUseCaseImpl(repository)
    }


    @Test
    fun should_validate_the_paging_data_creation_when_calling_use_case() =
        runBlockingTest {
            whenever(repository.getCharacters(""))
                .thenReturn(fakePagingSource)
            val result = getCharactersUseCase.invoke(GetCharactersUseCase.GetCharactersParams("", PagingConfig(20)))
            verify(repository).getCharacters("")

//            assertEquals(1, result.count())
        }
}