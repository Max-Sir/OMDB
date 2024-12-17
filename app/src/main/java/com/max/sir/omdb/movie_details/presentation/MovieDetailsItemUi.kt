package com.max.sir.omdb.movie_details.presentation

import com.google.gson.annotations.SerializedName

data class MovieDetailsItemUi(
    val plot: String,
    val poster: String,
    val released: String,
    val title: String,
    val year: String
)
