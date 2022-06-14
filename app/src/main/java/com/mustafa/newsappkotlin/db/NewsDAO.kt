package com.mustafa.newsappkotlin.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mustafa.newsappkotlin.models.ArticlesModel

@Dao
interface NewsDAO {

    @Insert
    fun insertNews(articles: ArticlesModel)

    @Query("DELETE FROM favoraties_table WHERE id= :id")
    fun deleteNews(id: Int)

    @Query("SELECT * FROM favoraties_table")
    fun getnews(): List<ArticlesModel>
}