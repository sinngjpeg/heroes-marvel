package br.com.sinngjpeg.marvelapp.framework.network

import br.com.sinngjpeg.marvelapp.framework.network.response.DataWrapperResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MarvelApi {
    @GET("characters")
    suspend fun getCharacters(
        @QueryMap
        queries: Map<String, String>,
    ): DataWrapperResponse
}
