package com.max.sir.omdb

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("Search") val Search: List<Movie>?
)