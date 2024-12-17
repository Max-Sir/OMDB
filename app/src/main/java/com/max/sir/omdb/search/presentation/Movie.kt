package com.max.sir.omdb.search.presentation

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Title") val title: String,
    @SerializedName("Year") val year: String,
    @SerializedName("Poster") val poster: String,
    val isFavorite: Boolean = false,
    @SerializedName("imdbID") val id: String = "",
)
