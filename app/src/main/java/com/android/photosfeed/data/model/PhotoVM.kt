package com.android.photosfeed.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class PhotoVM (
    val albumId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
) : Parcelable