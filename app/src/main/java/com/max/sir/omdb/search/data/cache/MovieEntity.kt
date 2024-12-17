package com.max.sir.omdb.search.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.max.sir.omdb.search.presentation.Movie

@Entity(tableName = "movies")
@TypeConverters(MovieEntityTypeConverter::class)
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    val id:String,
    @ColumnInfo("title")
    val title: String?,
    @ColumnInfo("year")
    val year: String?,
    @ColumnInfo("poster")
    val poster: String?,
    @ColumnInfo("isFavorite")
    val isFavorite: Boolean = false
) {
    companion object {
        fun fromMovie(movie: Movie): MovieEntity = MovieEntity(
            title = movie.title,
            year = movie.year,
            poster = movie.poster,
            isFavorite = movie.isFavorite,
            id = movie.id
        )

        fun toMovie(entity: MovieEntity): Movie = Movie(
            title = entity.title?:"",
            year = entity.year?:"",
            poster = entity.poster?:"",
            isFavorite = entity.isFavorite,
            id = entity.id
        )
    }
}
