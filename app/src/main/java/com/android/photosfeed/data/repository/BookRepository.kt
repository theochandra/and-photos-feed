package com.android.photosfeed.data.repository

import androidx.lifecycle.LiveData
import com.android.photosfeed.data.api.ApiResponse
import com.android.photosfeed.data.api.PhotoService
import com.android.photosfeed.data.mappers.PhotosResponseMapper
import com.android.photosfeed.data.model.Resource
import com.android.photosfeed.data.model.entity.Photo
import com.android.photosfeed.data.model.network.PhotoResponse
import com.android.photosfeed.data.room.PhotoDao
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookRepository
@Inject constructor(
    val photoService: PhotoService,
    val photoDao: PhotoDao
) : Repository {

    init {
        Timber.d("Injection BookRepository")
    }

    fun loadBooks(): LiveData<Resource<List<Photo>>> {
        return object : NetworkBoundRepository<List<Photo>, PhotoResponse, PhotosResponseMapper>() {

            override fun saveFetchData(items: PhotoResponse) {
                photoDao.insertPhotoList(photos = items.photoList)
            }

            override fun shouldFetch(data: List<Photo>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<Photo>> {
                return photoDao.getPhotoList()
            }

            override fun fetchService(): LiveData<ApiResponse<PhotoResponse>> {
                return photoService.fetchPhotos()
            }

            override fun mapper(): PhotosResponseMapper {
                return PhotosResponseMapper()
            }

            override fun onFetchFailed(message: String?) {
                Timber.d("On Fetch Photos Failed $message")
            }

        }.asLiveData()
    }

}