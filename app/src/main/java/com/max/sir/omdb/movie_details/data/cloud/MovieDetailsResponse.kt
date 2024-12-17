package com.max.sir.omdb.movie_details.data.cloud


import com.google.gson.annotations.SerializedName
import com.max.sir.omdb.movie_details.data.cache.MovieDetailEntity
import com.max.sir.omdb.movie_details.domain.MovieDetailsDomain

data class MovieDetailsResponse(
    @SerializedName("imdbID")
    val id: String? = null,
    @SerializedName("Plot")
    val plot: String? = null,
    @SerializedName("Poster")
    val poster: String? = null,
    @SerializedName("Released")
    val released: String? = null,
    @SerializedName("Title")
    val title: String? = null,
    @SerializedName("Year")
    val year: String? = null
){
        fun mapToMovieDetailsDomain(): MovieDetailsDomain =
            MovieDetailsDomain(
                plot = plot?:"",
                poster = poster?:"",
                released = released?:"",
                title = title?:"",
                year = year?:""
            )

    fun mapToMovieDetail(): MovieDetailEntity {
        return MovieDetailEntity(
            id = id?:"",
            plot = plot?:"",
            poster = poster?:"",
            released = released?:"",
            title = title?:"",
            year = year?:"",
        )
    }


}