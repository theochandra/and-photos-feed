package com.android.photosfeed.presentation.screen

import androidx.lifecycle.ViewModel
import com.android.photosfeed.data.repository.BookRepository
import javax.inject.Inject

class MainActivityViewModel
@Inject constructor(
    private val movieRepository: BookRepository
) : ViewModel() {



}