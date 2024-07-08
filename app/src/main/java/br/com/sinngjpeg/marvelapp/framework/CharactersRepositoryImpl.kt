package br.com.sinngjpeg.marvelapp.framework

import androidx.paging.PagingSource
import br.com.jpegsinng.core.data.repository.CharactersRemoteDataSource
import br.com.jpegsinng.core.data.repository.CharactersRepository
import br.com.jpegsinng.core.domain.model.Character
import br.com.sinngjpeg.marvelapp.framework.network.response.DataWrapperResponse
import br.com.sinngjpeg.marvelapp.framework.pagging.CharactersPagingSource
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
        private val remoteDataSource: CharactersRemoteDataSource<DataWrapperResponse>,
    ) : CharactersRepository {
        override fun getCharacters(query: String): PagingSource<Int, Character> {
            return CharactersPagingSource(remoteDataSource, query)

        }
    }
