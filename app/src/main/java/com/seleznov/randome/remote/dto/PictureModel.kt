package com.seleznov.randome.remote.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PictureModel(val thumbnail: String = "", val large: String = "") : Parcelable