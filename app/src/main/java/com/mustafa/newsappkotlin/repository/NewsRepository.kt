package com.mustafa.newsappkotlin.repository

import com.mustafa.newsappkotlin.models.HeadLinesModel
import com.mustafa.newsappkotlin.network.NewsApiService
import retrofit2.Call
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsApiService: NewsApiService
) {
    //    my personal Api key
    private val ApiKey = "78fc13aac8984c62a02ea891dcd7ff6d"

    fun getHeadLines(): Call<HeadLinesModel> {
        return newsApiService.getHeadLineService("eg", ApiKey)
    }
}