package com.mustafa.newsappkotlin.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mustafa.newsappkotlin.models.ArticlesModel

@Database(entities = [ArticlesModel::class], version = 1)
abstract class NewsDB : RoomDatabase() {

    abstract fun newsDAO(): NewsDAO

}