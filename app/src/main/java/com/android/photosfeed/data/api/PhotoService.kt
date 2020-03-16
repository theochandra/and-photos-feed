package com.android.photosfeed.data.api

import androidx.lifecycle.LiveData
import com.android.photosfeed.data.model.network.PhotoResponse
import retrofit2.http.GET

interface PhotoService {

    @GET("/photos")
    fun fetchPhotos(): LiveData<ApiResponse<PhotoResponse>>

}