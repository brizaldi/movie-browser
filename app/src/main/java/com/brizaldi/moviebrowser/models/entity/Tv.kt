package com.brizaldi.moviebrowser.models.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.brizaldi.moviebrowser.models.Keyword
import com.brizaldi.moviebrowser.models.Review
import com.brizaldi.moviebrowser.models.Video
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Tv(
    @PrimaryKey val id: Int,
    var page: Int,
    var keywords: List<Keyword>? = ArrayList(),
    var videos: List<Video>? = ArrayList(),
    var reviews: List<Review>? = ArrayList(),
    val poster_path: String?,
    val popularity: Float,
    val backdrop_path: String?,
    val vote_average: Float,
    val overview: String,
    val first_air_date: String,
    val origin_country: List<String>,
    val genre_ids: List<Int>,
    val original_language: String,
    val vote_count: Int,
    val name: String,
    val original_name: String
) : Parcelable