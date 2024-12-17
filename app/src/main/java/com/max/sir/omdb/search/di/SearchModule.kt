package com.max.sir.omdb.search.di

import com.max.sir.omdb.core.AppDatabase
import com.max.sir.omdb.search.data.cache.MovieDao
import com.max.sir.omdb.search.data.cloud.MovieApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SearchModule {


    @Provides
    fun provideMovieDao(database: AppDatabase): MovieDao = database.movieDao()


    @Provides
    @Singleton
    fun provideMovieApiService(retrofit: Retrofit): MovieApiService {
        return retrofit.create(MovieApiService::class.java)
    }

}