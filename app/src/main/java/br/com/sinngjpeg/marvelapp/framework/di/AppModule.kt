package br.com.sinngjpeg.marvelapp.framework.di

import br.com.sinngjpeg.marvelapp.framework.imageloader.GlideImageLoader
import br.com.sinngjpeg.marvelapp.framework.imageloader.ImageLoader
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
interface AppModule {

    @Binds
    fun bindImageLoader(imageLoader: GlideImageLoader): ImageLoader

}