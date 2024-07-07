package br.com.jpegsinng.core.data.repository

interface CharactersRepository {
    fun getCharacters(query: String): PaggingSource<Int, Character>
}
