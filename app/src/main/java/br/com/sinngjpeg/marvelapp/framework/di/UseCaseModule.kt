package br.com.sinngjpeg.marvelapp.framework.di

import br.com.jpegsinng.core.usecase.GetCharacterCategoriesUseCase
import br.com.jpegsinng.core.usecase.GetCharacterCategoriesUseCaseImpl
import br.com.jpegsinng.core.usecase.GetCharactersUseCase
import br.com.jpegsinng.core.usecase.GetCharactersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindsCharactersUseCase(useCase: GetCharactersUseCaseImpl): GetCharactersUseCase

    @Binds
    fun bindGetComicsUseCase(useCase: GetCharacterCategoriesUseCaseImpl): GetCharacterCategoriesUseCase
}
