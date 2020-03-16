package com.android.photosfeed.data.repository

import androidx.lifecycle.LiveData
import com.android.photosfeed.data.api.ApiResponse
import com.android.photosfeed.data.api.BooksService
import com.android.photosfeed.data.mappers.BooksResponseMapper
import com.android.photosfeed.data.model.Resource
import com.android.photosfeed.data.model.entity.Book
import com.android.photosfeed.data.model.network.BooksResponse
import com.android.photosfeed.data.room.BookDao
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookRepository
@Inject constructor(
    val booksService: BooksService,
    val bookDao: BookDao
) : Repository {

    init {
        Timber.d("Injection BookRepository")
    }

    fun loadBooks(): LiveData<Resource<List<Book>>> {
        return object : NetworkBoundRepository<List<Book>, BooksResponse, BooksResponseMapper>() {

            override fun saveFetchData(items: BooksResponse) {
                bookDao.insertBookList(books = items.bookList)
            }

            override fun shouldFetch(data: List<Book>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<Book>> {
                return bookDao.getBookList()
            }

            override fun fetchService(): LiveData<ApiResponse<BooksResponse>> {
                return booksService.fetchBooks()
            }

            override fun mapper(): BooksResponseMapper {
                return BooksResponseMapper()
            }

            override fun onFetchFailed(message: String?) {
                Timber.d("On Fetch Books Failed $message")
            }

        }.asLiveData()
    }

}