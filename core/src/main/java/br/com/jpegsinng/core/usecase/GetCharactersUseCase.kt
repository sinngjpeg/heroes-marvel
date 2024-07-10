package br.com.jpegsinng.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.jpegsinng.core.data.repository.CharactersRepository
import br.com.jpegsinng.core.usecase.base.PagingUseCase
import br.com.jpegsinng.core.domain.model.Character
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetCharactersUseCase {
    operator fun invoke(params: GetCharacterParams): Flow<PagingData<Character>>
    data class GetCharacterParams(val query: String, val pagingConfig: PagingConfig)
}

class GetCharactersUseCaseImpl @Inject constructor(
    private val charactersRepository: CharactersRepository
) : PagingUseCase<GetCharactersUseCase.GetCharacterParams, Character>(),
    GetCharactersUseCase {
    override fun createFlowObservable(params: GetCharactersUseCase.GetCharacterParams): Flow<PagingData<Character>> {
        val pagingSource = charactersRepository.getCharacters(params.query)
        return Pager(config = params.pagingConfig) {
            pagingSource
        }.flow
    }
}