package com.max.sir.omdb.movie_details.data.cloud

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDetailsService {

    @GET("/")
    suspend fun getDetails(
        @Query("i") id: String,
    ): Response<MovieDetailsResponse>

}