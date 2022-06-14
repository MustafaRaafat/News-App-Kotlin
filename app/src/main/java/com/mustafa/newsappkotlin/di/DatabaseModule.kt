package com.mustafa.newsappkotlin.di

import android.app.Application
import androidx.room.Room
import com.mustafa.newsappkotlin.db.NewsDAO
import com.mustafa.newsappkotlin.db.NewsDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {


    @Provides
    @Singleton
    fun provideDB(application: Application): NewsDB {
        return Room.databaseBuilder(
            application,
            NewsDB::class.java,
            "fav_DB"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(newsDB: NewsDB): NewsDAO {
        return newsDB.newsDAO()
    }
}