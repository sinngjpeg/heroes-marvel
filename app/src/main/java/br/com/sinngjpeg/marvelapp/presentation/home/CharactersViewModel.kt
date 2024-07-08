package br.com.sinngjpeg.marvelapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import br.com.jpegsinng.core.domain.model.Character
import br.com.jpegsinng.core.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
        private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {
        fun charactersPagingData(query: String): Flow<PagingData<Character>> =
            getCharactersUseCase(
                GetCharactersUseCase.GetCharactersParams(query, getPageConfig()),
            ).cachedIn(viewModelScope)

        private fun getPageConfig() = PagingConfig(pageSize = 20)
    }
