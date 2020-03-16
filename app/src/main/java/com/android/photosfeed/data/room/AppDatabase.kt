package com.android.photosfeed.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.photosfeed.data.model.entity.Photo

@Database(entities = [(Photo::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun photosDao(): PhotoDao

}