package br.com.jpegsinng.core.data.repository

import br.com.jpegsinng.core.domain.model.CharacterPaging
import br.com.jpegsinng.core.domain.model.Comic
import br.com.jpegsinng.core.domain.model.Event

interface CharactersRemoteDataSource {
    suspend fun fetchCharacters(
        queries: Map<String,
                String>
    ): CharacterPaging

    suspend fun fetchComics(
        characterId: Int
    ): List<Comic>

    suspend fun fetchEvents(
        characterId: Int
    ): List<Event>
}

