package com.mudassir.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City(
    val description: String,
    val image: String,
    val name: String
) : Parcelable