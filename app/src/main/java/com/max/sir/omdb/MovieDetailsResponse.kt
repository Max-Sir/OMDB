package com.max.sir.omdb


import com.google.gson.annotations.SerializedName

data class MovieDetailsResponse(
    @SerializedName("Plot")
    val plot: String,
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Released")
    val released: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Year")
    val year: String
)