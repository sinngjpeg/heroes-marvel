package br.com.sinngjpeg.marvelapp.framework.di

import br.com.jpegsinng.core.data.repository.CharactersRemoteDataSource
import br.com.jpegsinng.core.data.repository.CharactersRepository
import br.com.sinngjpeg.marvelapp.framework.CharactersRepositoryImpl
import br.com.sinngjpeg.marvelapp.framework.network.response.DataWrapperResponse
import br.com.sinngjpeg.marvelapp.remote.RetrofitCharactersDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindCharactersRepository(
        repository: CharactersRepositoryImpl
    ): CharactersRepository

    @Binds
    fun bindRemoteDataSource(
        dataSource: RetrofitCharactersDataSource
    ): CharactersRemoteDataSource<DataWrapperResponse>
}
