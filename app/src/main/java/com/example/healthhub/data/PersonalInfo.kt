package com.example.healthhub.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonalInfo(
    var nickname: String? = null,
    var height: String? = null,
    var weight: String? = null,
): Parcelable
