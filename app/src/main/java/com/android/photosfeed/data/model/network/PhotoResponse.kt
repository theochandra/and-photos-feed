package com.android.photosfeed.data.model.network

import com.android.photosfeed.data.model.entity.Photo

class PhotoResponse (
    val photoList: List<Photo>
) : NetworkResponseModel