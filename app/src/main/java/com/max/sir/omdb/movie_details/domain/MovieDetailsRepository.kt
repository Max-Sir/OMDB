package com.max.sir.omdb.movie_details.domain

interface MovieDetailsRepository {

    suspend fun loadDetails(id: String): MovieDetailsDomain

}