package com.android.photosfeed.data.api

import androidx.lifecycle.LiveData
import com.android.photosfeed.data.model.network.BooksResponse
import retrofit2.http.GET

interface BooksService {

    @GET("/photos")
    fun fetchBooks(): LiveData<ApiResponse<BooksResponse>>

}