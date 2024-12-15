package com.max.sir.omdb

import android.util.Log
import javax.inject.Inject

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository @Inject constructor(
    private val api: MovieApiService,
    private val dao: MovieDao
) {
    suspend fun searchMovies(apiKey: String, query: String): List<Movie> {
        return withContext(Dispatchers.IO) {
            val response = api.searchMovies(apiKey, query)
            if (response.isSuccessful) {
                val movies =
                    response.body()?.Search?.map { MovieEntity.fromMovie(it) } ?: emptyList()
                //dao.insertMovies(movies)
                Log.i("mov", "$movies")
                movies.map { MovieEntity.toMovie(it) }
            } else {
                //dao.searchMovies("%$query%").map { MovieEntity.toMovie(it) }
                Log.i("mov", "nothing")
                emptyList()
            }
        }
    }

    suspend fun getFavorites(): List<Movie> = withContext(Dispatchers.IO) {
        //dao.getFavorites().map { MovieEntity.toMovie(it) }
        emptyList()
    }

    suspend fun toggleFavorite(movie: Movie) {
        withContext(Dispatchers.IO) {
            val entity = MovieEntity.fromMovie(movie).copy(isFavorite = !movie.isFavorite)
            //dao.updateMovie(entity)
        }
    }
}
