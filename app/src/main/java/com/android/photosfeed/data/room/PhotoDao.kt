package com.android.photosfeed.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.photosfeed.data.model.entity.Photo

@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhotoList(photos: List<Photo>)

    @Query("SELECT * FROM Photo")
    fun getPhotoList(): LiveData<List<Photo>>

}