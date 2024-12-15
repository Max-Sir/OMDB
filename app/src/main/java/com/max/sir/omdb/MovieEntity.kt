package com.max.sir.omdb

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "movies")
@TypeConverters(MovieEntityTypeConverter::class)
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val year: String,
    val poster: String,
    val isFavorite: Boolean = false
) {
    companion object {
        fun fromMovie(movie: Movie): MovieEntity = MovieEntity(
            title = movie.title,
            year = movie.year,
            poster = movie.poster,
            isFavorite = movie.isFavorite
        )

        fun toMovie(entity: MovieEntity): Movie = Movie(
            title = entity.title,
            year = entity.year,
            poster = entity.poster,
            isFavorite = entity.isFavorite
        )
    }
}
