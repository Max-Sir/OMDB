package com.max.sir.omdb.search.data.cloud

import com.google.gson.annotations.SerializedName
import com.max.sir.omdb.search.presentation.Movie

data class MovieResponse(
    @SerializedName("Search") val search: List<Movie>?
)