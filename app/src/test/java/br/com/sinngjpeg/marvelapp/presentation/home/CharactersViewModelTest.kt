package br.com.sinngjpeg.marvelapp.presentation.home

import androidx.paging.PagingData
import br.com.jpegsinng.core.usecase.GetCharactersUseCase
import br.com.jpegsinng.testing.MainCoroutineRules
import br.com.jpegsinng.testing.model.CharacterFactory
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharactersViewModelTest {
    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutineRule = MainCoroutineRules()

    @Mock
    lateinit var getCharactersUseCase: GetCharactersUseCase

    private lateinit var charactersViewModel: CharactersViewModel

    private val charactersFactory = CharacterFactory()

    private val pagingDataCharacters =
        PagingData.from(
            listOf(
                charactersFactory.create(CharacterFactory.Hero.ThreeDMan),
                charactersFactory.create(CharacterFactory.Hero.ABomb),
            ),
        )

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        charactersViewModel = CharactersViewModel(getCharactersUseCase)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun should_validate_the_paging_data_when_calling_characters_paging_data() =
        runBlockingTest {
            whenever(getCharactersUseCase(any())).thenReturn(
                flowOf(pagingDataCharacters),
            )
            val result = charactersViewModel.charactersPagingData("")
            assertEquals(1, result.count())
        }

    @ExperimentalCoroutinesApi
    @Test(expected = RuntimeException::class)
    fun should_throw_an_exception_when_calling_to_the_returns_an_exception() =
        runBlockingTest {
            whenever(
                getCharactersUseCase(any()),
            ).thenThrow(RuntimeException())
            charactersViewModel.charactersPagingData("")
        }
}
