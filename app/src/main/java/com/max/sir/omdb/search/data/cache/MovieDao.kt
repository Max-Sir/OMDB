package com.max.sir.omdb.search.data.cache

import androidx.room.*

@Dao
interface MovieDao {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertMovies(movies: List<MovieEntity>): Unit

        @Query("SELECT * FROM movies WHERE title LIKE :query")
        fun searchMovies(query: String): List<MovieEntity>

        @Query("SELECT * FROM movies WHERE isFavorite = 1")
        fun getFavorites(): List<MovieEntity>

        @Update
        fun updateMovie(movie: MovieEntity)
}