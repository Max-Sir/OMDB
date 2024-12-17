package com.max.sir.omdb.movie_details.di

import com.max.sir.omdb.movie_details.data.MovieDetailsRepositoryImpl
import com.max.sir.omdb.movie_details.domain.MovieDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DetailsBindsModule {

    @Singleton
    @Binds
    fun bindMovieDetailsRepository(obj: MovieDetailsRepositoryImpl): MovieDetailsRepository

}