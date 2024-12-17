package com.max.sir.omdb.movie_details.data

import com.max.sir.omdb.core.ResponseFailedException
import com.max.sir.omdb.movie_details.data.cloud.MovieDetailsService
import com.max.sir.omdb.movie_details.domain.MovieDetailsDomain
import com.max.sir.omdb.movie_details.domain.MovieDetailsRepository
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(
    private val service: MovieDetailsService
): MovieDetailsRepository {

    override suspend fun loadDetails(id: String): MovieDetailsDomain{
            val response = service.getDetails(id)
           return if (response.isSuccessful) {
               response.body()?.mapToMovieDetailsDomain() ?: throw ResponseFailedException()
           } else throw ResponseFailedException()

    }
}