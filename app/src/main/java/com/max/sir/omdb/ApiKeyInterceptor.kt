package com.max.sir.omdb

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(private val apiKey: String) : Interceptor {
       override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl: HttpUrl = originalRequest.url

        // Add the query parameter to the URL
        val newUrl = originalUrl.newBuilder()
            .addQueryParameter("apikey", apiKey) // Replace "apikey" with your parameter name
            .build()

        // Build the new request with the updated URL
        val newRequest = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }
}