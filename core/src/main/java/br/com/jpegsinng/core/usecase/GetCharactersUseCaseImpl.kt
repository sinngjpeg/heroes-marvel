package br.com.jpegsinng.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.jpegsinng.core.data.repository.CharactersRepository
import br.com.jpegsinng.core.domain.model.Character
import br.com.jpegsinng.core.usecase.GetCharactersUseCase.GetCharactersParams
import br.com.jpegsinng.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetCharactersUseCase {
    operator fun invoke(params: GetCharactersParams): Flow<PagingData<Character>>
    data class GetCharactersParams(val query: String, val pagingConfig: PagingConfig)
}

class GetCharactersUseCaseImpl @Inject constructor(
        private val charactersRepository: CharactersRepository,
    ) : PagingUseCase<GetCharactersParams, Character>(),
        GetCharactersUseCase {

        override fun createFlowObservable(parameters: GetCharactersParams): Flow<PagingData<Character>> =
            Pager(config = parameters.pagingConfig) {
                charactersRepository.getCharacters(parameters.query)
            }.flow
    }
