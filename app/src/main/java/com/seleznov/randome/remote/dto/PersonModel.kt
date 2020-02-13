package com.seleznov.randome.remote.dto

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonModel(
    val gender: String = "",
    val email: String = "",
    val phone: String = "",
    val name: NameModel? = null,
    val picture: PictureModel? = null
) : Parcelable {

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<PersonModel>() {
            override fun areItemsTheSame(oldItem: PersonModel, newItem: PersonModel): Boolean =
                oldItem.name?.first == newItem.name?.first && oldItem.name?.last == newItem.name?.last

            override fun areContentsTheSame(oldItem: PersonModel, newItem: PersonModel): Boolean =
                oldItem.name?.first == newItem.name?.first && oldItem.name?.last == newItem.name?.last
                        && oldItem.email == newItem.email && oldItem.gender == newItem.gender
                        && oldItem.phone == newItem.phone
        }
    }

}