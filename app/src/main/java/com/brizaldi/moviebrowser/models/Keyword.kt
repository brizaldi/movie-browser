package com.brizaldi.moviebrowser.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Keyword(
    val id: Int,
    val name: String
) : Parcelable