package com.android.photosfeed.data.mappers

import com.android.photosfeed.data.model.network.NetworkResponseModel

interface NetworkResponseMapper<in FROM : NetworkResponseModel> {
    fun onLastPage(response: FROM): Boolean
}