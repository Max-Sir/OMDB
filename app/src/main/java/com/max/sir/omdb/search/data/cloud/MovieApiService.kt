package com.max.sir.omdb.search.data.cloud

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("/")
    suspend fun searchMovies(
        @Query("s") query: String,
    ): Response<MovieResponse>

}
