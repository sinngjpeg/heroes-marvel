package br.com.jpegsinng.core.data.repository

import androidx.paging.PagingSource
import br.com.jpegsinng.core.domain.model.Character
import br.com.jpegsinng.core.domain.model.Comic
import br.com.jpegsinng.core.domain.model.Event

interface CharactersRepository {
    fun getCharacters(query: String): PagingSource<Int, Character>
    suspend fun getComics(characterId: Int): List<Comic>
    suspend fun getEvents(characterId: Int): List<Event>
}
