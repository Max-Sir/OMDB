package com.max.sir.omdb.main.di

import com.max.sir.omdb.core.ImageLoader
import com.max.sir.omdb.core.ImageLoaderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface BindsAppModule {

    @Singleton
    @Binds
    fun bindImageLoader(obj: ImageLoaderImpl): ImageLoader

}