package com.mustafa.newsappkotlin.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "favoraties_table")
data class ArticlesModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @Ignore val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
) {

    class Source(val id: String, val name: String) {

    }
}