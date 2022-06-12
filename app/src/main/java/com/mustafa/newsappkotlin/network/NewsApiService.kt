package com.mustafa.newsappkotlin.network

import com.mustafa.newsappkotlin.models.HeadLinesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    fun getHeadLineService(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Call<HeadLinesModel>
}