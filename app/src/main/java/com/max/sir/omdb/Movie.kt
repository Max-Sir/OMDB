package com.max.sir.omdb

data class Movie(
    val title: String,
    val year: String,
    val poster: String,
    val isFavorite: Boolean = false
)
