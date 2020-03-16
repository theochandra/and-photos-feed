package com.android.photosfeed.data.mappers

import com.android.photosfeed.data.model.network.BooksResponse

class BooksResponseMapper : NetworkResponseMapper<BooksResponse> {

    override fun onLastPage(response: BooksResponse): Boolean {
        return true
    }

}