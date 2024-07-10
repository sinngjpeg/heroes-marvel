package br.com.sinngjpeg.marvelapp.framework.pagging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.jpegsinng.core.data.repository.CharactersRemoteDataSource
import br.com.jpegsinng.core.domain.model.Character

class CharactersPagingSource(
    private val remoteDataSource: CharactersRemoteDataSource,
    private val query: String,
) : PagingSource<Int, Character>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> =
        try {
            val offset = params.key ?: 0
            val queries =
                hashMapOf(
                    "offset" to offset.toString(),
                )
            if (query.isNotEmpty()) {
                queries["nameStartsWith"] = query
            }

            val characterPaging = remoteDataSource.fetchCharacters(queries)

            val responseOffset = characterPaging.offset
            val totalCharacters = characterPaging.total
            LoadResult.Page(
                data = characterPaging.characters,
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

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(LIMIT) ?: anchorPage?.nextKey?.minus(LIMIT)
        }

    companion object {
        private const val LIMIT = 20
    }
}
