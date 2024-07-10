package br.com.jpegsinng.testing.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.jpegsinng.core.domain.model.Character

class PagingSourceFactory {
    fun create(heroes: List<Character>) =
        object : PagingSource<Int, Character>() {
            override fun getRefreshKey(state: PagingState<Int, Character>) = 1

            override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> =
                LoadResult.Page(
                    data = heroes,
                    prevKey = null,
                    nextKey = 20,
                )
        }
}
