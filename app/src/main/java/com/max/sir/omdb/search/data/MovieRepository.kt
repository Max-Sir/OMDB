package com.max.sir.omdb.search.data

import android.util.Log
import com.max.sir.omdb.search.data.cache.MovieDao
import com.max.sir.omdb.search.data.cache.MovieEntity
import com.max.sir.omdb.search.data.cloud.MovieApiService
import com.max.sir.omdb.search.presentation.Movie
import javax.inject.Inject

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository @Inject constructor(
    private val api: MovieApiService,
    private val dao: MovieDao
) {
    suspend fun searchMovies(query: String): List<Movie> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.searchMovies(query)
                if (response.isSuccessful) {
                    val movies =
                        response.body()?.search?.map { MovieEntity.fromMovie(it) } ?: emptyList()
                    if (movies.isNotEmpty()) dao.insertMovies(movies)
                    movies.map { MovieEntity.toMovie(it) }
                } else {
                    dao.searchMovies("%$query%").map { MovieEntity.toMovie(it) }
                }
            } catch (e: Exception) {
                dao.searchMovies("%$query%").map { MovieEntity.toMovie(it) }
            }
        }
    }


    suspend fun getFavorites(): List<Movie> = withContext(Dispatchers.IO) {
        dao.getFavorites().map { MovieEntity.toMovie(it) }
        emptyList()
    }

    suspend fun toggleFavorite(movie: Movie) {
        withContext(Dispatchers.IO) {
            val entity = MovieEntity.fromMovie(movie).copy(isFavorite = !movie.isFavorite)
            dao.updateMovie(entity)
        }
    }
}
