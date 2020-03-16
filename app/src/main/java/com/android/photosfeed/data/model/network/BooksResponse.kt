package com.android.photosfeed.data.model.network

import com.android.photosfeed.data.model.entity.Book

class BooksResponse (
    val bookList: List<Book>
) : NetworkResponseModel