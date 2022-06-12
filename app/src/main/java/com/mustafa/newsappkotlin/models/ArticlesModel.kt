package com.mustafa.newsappkotlin.models

class ArticlesModel(
    val source: Source,
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