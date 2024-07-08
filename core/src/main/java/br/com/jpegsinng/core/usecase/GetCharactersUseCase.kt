package br.com.jpegsinng.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.jpegsinng.core.data.repository.CharactersRepository
import br.com.jpegsinng.core.usecase.base.PagingUseCase
import br.com.jpegsinng.core.domain.model.Character
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetCharactersUseCase @Inject constructor(
        private val charactersRepository: CharactersRepository,
    ) : PagingUseCase<GetCharactersUseCase.GetCharactersParams, Character>() {

        override fun createFlowObservable(parameters: GetCharactersParams): Flow<PagingData<Character>> =
            Pager(config = parameters.pagingConfig) {
                charactersRepository.getCharacters(parameters.query)
            }.flow

        data class GetCharactersParams(
            val query: String,
            val pagingConfig: PagingConfig,
        )
    }
