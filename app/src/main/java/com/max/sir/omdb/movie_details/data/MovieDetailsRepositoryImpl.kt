package com.max.sir.omdb.movie_details.data

import com.max.sir.omdb.core.ResponseFailedException
import com.max.sir.omdb.movie_details.data.cloud.MovieDetailsService
import com.max.sir.omdb.movie_details.data.cache.MovieDetailsDao
import com.max.sir.omdb.movie_details.domain.MovieDetailsDomain
import com.max.sir.omdb.movie_details.domain.MovieDetailsRepository
import com.max.sir.omdb.movie_details.data.cache.mapToMovieDetailsDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(
    private val service: MovieDetailsService,
    private val movieDetailsDao: MovieDetailsDao,
) : MovieDetailsRepository {

    override suspend fun loadDetails(id: String): MovieDetailsDomain = withContext(Dispatchers.IO) {
        val localDetail = movieDetailsDao.getDetailById(id).value

        if (localDetail != null) {
            return@withContext localDetail.mapToMovieDetailsDomain()
        } else {
            val response = service.getDetails(id)

            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) {
                    movieDetailsDao.insert(responseBody.mapToMovieDetail())
                    return@withContext responseBody.mapToMovieDetailsDomain()
                } else if (localDetail != null) {
                    return@withContext localDetail.mapToMovieDetailsDomain()
                } else {
                    throw ResponseFailedException()
                }
            } else {
                if (localDetail != null) {
                    return@withContext localDetail.mapToMovieDetailsDomain()
                } else {
                    throw ResponseFailedException()
                }
            }
        }
    }


}
