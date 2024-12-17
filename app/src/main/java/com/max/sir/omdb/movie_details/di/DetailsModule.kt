package com.max.sir.omdb.movie_details.di

import com.max.sir.omdb.core.AppDatabase
import com.max.sir.omdb.movie_details.data.cloud.MovieDetailsService
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
class DetailsModule {


    @Provides
    @Singleton
    fun provideMovieDetailsService(retrofit: Retrofit): MovieDetailsService {
        return retrofit.create(MovieDetailsService::class.java)
    }

}