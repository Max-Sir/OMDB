package com.max.sir.omdb.movie_details.domain

import com.max.sir.omdb.movie_details.presentation.MovieDetailsItemUi

data class MovieDetailsDomain(
    val plot: String,
    val poster: String,
    val released: String,
    val title: String,
    val year: String,
){

    fun mapToMovieDetailsUi(): MovieDetailsItemUi =
        MovieDetailsItemUi(
            plot = plot?:"",
            poster = poster?:"",
            released = released?:"",
            title = title?:"",
            year = year?:"",
        )

}
