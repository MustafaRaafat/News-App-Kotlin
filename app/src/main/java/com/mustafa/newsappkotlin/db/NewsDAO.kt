package com.mustafa.newsappkotlin.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mustafa.newsappkotlin.models.ArticlesModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDAO {

    @Insert
    suspend fun insertNews(articles: ArticlesModel)

    @Query("DELETE FROM favoraties_table WHERE id= :id")
    suspend fun deleteNews(id: Int)

    @Query("SELECT * FROM favoraties_table")
    suspend fun getnews(): List<ArticlesModel>
}