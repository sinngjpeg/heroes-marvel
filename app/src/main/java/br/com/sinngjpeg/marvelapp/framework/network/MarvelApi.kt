package br.com.sinngjpeg.marvelapp.framework.network

import br.com.sinngjpeg.marvelapp.framework.network.response.CharacterResponse
import br.com.sinngjpeg.marvelapp.framework.network.response.ComicResponse
import br.com.sinngjpeg.marvelapp.framework.network.response.DataWrapperResponse
import br.com.sinngjpeg.marvelapp.framework.network.response.EventResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface MarvelApi {

    @GET("characters")
    suspend fun getCharacters(
        @QueryMap
        queries: Map<String, String>
    ): DataWrapperResponse<CharacterResponse>

    @GET("characters/{characterId}/comics")
    suspend fun getComics(
        @Path("characterId")
        charactersId: Int
    ): DataWrapperResponse<ComicResponse>

    @GET("characters/{characterId}/events")
    suspend fun getEvents(
        @Path("characterId")
        charactersId: Int
    ): DataWrapperResponse<EventResponse>
}
