package com.android.photosfeed.data.mappers

import com.android.photosfeed.data.model.network.PhotoResponse

class PhotosResponseMapper : NetworkResponseMapper<PhotoResponse> {

    override fun onLastPage(response: PhotoResponse): Boolean {
        return true
    }

}