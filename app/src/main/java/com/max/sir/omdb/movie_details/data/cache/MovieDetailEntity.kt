package com.max.sir.omdb.movie_details.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.max.sir.omdb.movie_details.domain.MovieDetailsDomain

@Entity(tableName = "movie_details")
data class MovieDetailEntity(
    @PrimaryKey(autoGenerate = false) val id: String,
    @ColumnInfo("plot")
    val plot: String,
    @ColumnInfo("poster")
    val poster: String,
    @ColumnInfo("released")
    val released: String,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("year")
    val year: String,
)

fun MovieDetailEntity.mapToMovieDetailsDomain(): MovieDetailsDomain {
    return MovieDetailsDomain(
        plot = this.plot,
        poster = this.poster,
        released = this.released,
        title = this.title,
        year = this.year
    )
}