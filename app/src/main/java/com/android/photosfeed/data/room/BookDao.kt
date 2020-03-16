package com.android.photosfeed.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.photosfeed.data.model.entity.Book

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBookList(books: List<Book>)

    @Query("SELECT * FROM Book")
    fun getBookList(): LiveData<List<Book>>

}