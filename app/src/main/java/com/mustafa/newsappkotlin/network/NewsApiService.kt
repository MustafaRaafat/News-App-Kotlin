package com.mustafa.newsappkotlin.network

import com.mustafa.newsappkotlin.models.HeadLinesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    suspend fun getHeadLineService(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Response<HeadLinesModel>
}