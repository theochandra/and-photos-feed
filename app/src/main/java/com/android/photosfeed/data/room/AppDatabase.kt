package com.android.photosfeed.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.photosfeed.data.model.entity.Book

@Database(entities = [(Book::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDao

}