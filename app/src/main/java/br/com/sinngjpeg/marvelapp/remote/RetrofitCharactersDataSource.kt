package br.com.sinngjpeg.marvelapp.remote

import br.com.jpegsinng.core.data.repository.CharactersRemoteDataSource
import br.com.sinngjpeg.marvelapp.framework.network.MarvelApi
import br.com.sinngjpeg.marvelapp.framework.network.response.DataWrapperResponse
import javax.inject.Inject

class RetrofitCharactersDataSource @Inject constructor(
    private val marvelApi: MarvelApi
): CharactersRemoteDataSource<DataWrapperResponse>
{
    override suspend fun fetchCharacters(queries: Map<String, String>): DataWrapperResponse {
        return marvelApi.getCharacters(queries)
    }
}