package com.max.sir.omdb

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("/")
    suspend fun searchMovies(
        @Query("s") query: String,
    ): Response<MovieResponse>

    @GET("/")
    suspend fun getDetails(
        @Query("i") id: String,
    ): Response<MovieDetailsResponse>
}
