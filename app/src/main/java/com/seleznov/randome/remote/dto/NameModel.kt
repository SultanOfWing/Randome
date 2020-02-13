package com.seleznov.randome.remote.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NameModel(val first: String = "", val last: String = "") : Parcelable