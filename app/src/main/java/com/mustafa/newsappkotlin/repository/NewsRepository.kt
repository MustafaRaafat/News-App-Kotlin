package com.mustafa.newsappkotlin.repository

import com.mustafa.newsappkotlin.db.NewsDAO
import com.mustafa.newsappkotlin.models.ArticlesModel
import com.mustafa.newsappkotlin.models.HeadLinesModel
import com.mustafa.newsappkotlin.network.NewsApiService
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsApiService: NewsApiService,
    private val newsDAO: NewsDAO
) {
    //    my personal Api key
    private val ApiKey = "78fc13aac8984c62a02ea891dcd7ff6d"

    suspend fun getHeadLines(): Response<HeadLinesModel> {
        return newsApiService.getHeadLineService("eg", ApiKey)
    }

    suspend fun insertNews(articlesModel: ArticlesModel) {
        newsDAO.insertNews(articlesModel)
    }

    suspend fun deletenews(id: Int) {
        newsDAO.deleteNews(id)
    }

    suspend fun getFavNews(): List<ArticlesModel> {
        return newsDAO.getnews()
    }
}