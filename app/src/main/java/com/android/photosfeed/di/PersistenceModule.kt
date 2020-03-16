package com.android.photosfeed.di

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.android.photosfeed.data.room.AppDatabase
import com.android.photosfeed.data.room.PhotoDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, "photos_feed.db")
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(@NonNull database: AppDatabase): PhotoDao {
        return database.photosDao()
    }

}