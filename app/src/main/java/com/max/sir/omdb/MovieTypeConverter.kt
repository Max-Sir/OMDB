package com.max.sir.omdb

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MovieEntityTypeConverter {

    @TypeConverter
    fun fromMovieEntityList(movies: List<MovieEntity>?): String? {
        return if (movies == null) null else Gson().toJson(movies)
    }

    @TypeConverter
    fun toMovieEntityList(moviesJson: String?): List<MovieEntity>? {
        return if (moviesJson == null) null else Gson().fromJson(
            moviesJson,
            object : TypeToken<List<MovieEntity>>() {}.type
        )
    }

    @TypeConverter
    fun fromMovieEntity(movie: MovieEntity?): String? {
        return if (movie == null) null else Gson().toJson(movie)
    }

    @TypeConverter
    fun toMovieEntity(movieJson: String?): MovieEntity? {
        return if (movieJson == null) null else Gson().fromJson(movieJson, MovieEntity::class.java)
    }
}
