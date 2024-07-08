package br.com.sinngjpeg.marvelapp.framework.pagging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.jpegsinng.core.data.repository.CharactersRemoteDataSource
import br.com.jpegsinng.core.domain.model.Character
import br.com.sinngjpeg.marvelapp.framework.network.response.DataWrapperResponse
import br.com.sinngjpeg.marvelapp.framework.network.response.toCharacter

class CharactersPagingSource(
    private val remoteDataSource: CharactersRemoteDataSource<DataWrapperResponse>,
    private val query: String,
) : PagingSource<Int, Character>() {

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(LIMIT) ?: anchorPage?.nextKey?.minus(LIMIT)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> =
        try {
            val offset = params.key ?: 0
            val queries =
                hashMapOf(
                    "offset" to offset.toString(),
                    "limit" to params.loadSize.toString(),
                )
            if (query.isNotEmpty()) {
                queries["nameStartsWith"] = query
            }

            val response = remoteDataSource.fetchCharacters(queries)
            val responseOffset = response.data.offset
            val totalCharacters = response.data.total

            LoadResult.Page(
                data = response.data.results.map { it.toCharacter() },
                prevKey = null,
                nextKey =
                    if (responseOffset < totalCharacters) {
                        responseOffset + LIMIT
                    } else {
                        null
                    },
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }

    companion object {
        private const val LIMIT = 20
    }
}
