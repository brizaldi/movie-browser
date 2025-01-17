package com.brizaldi.moviebrowser.binding

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.brizaldi.moviebrowser.api.Api
import com.brizaldi.moviebrowser.extension.addPrimaryChip
import com.brizaldi.moviebrowser.extension.bindResource
import com.brizaldi.moviebrowser.extension.requestGlideListener
import com.brizaldi.moviebrowser.extension.visible
import com.brizaldi.moviebrowser.models.Keyword
import com.brizaldi.moviebrowser.models.Resource
import com.brizaldi.moviebrowser.models.entity.Movie
import com.brizaldi.moviebrowser.models.entity.Tv
import com.bumptech.glide.Glide
import com.google.android.material.chip.ChipGroup
import com.skydoves.whatif.whatIfNotNull
import com.skydoves.whatif.whatIfNotNullOrEmpty

@BindingAdapter("visibilityByResource")
fun bindVisibilityByResource(view: View, resource: Resource<List<Any>>?) {
    view.bindResource(resource) {
        it.data.whatIfNotNull {
            view.visible()
        }
    }
}

@BindingAdapter("mapKeywordList")
fun bindMapKeywordList(view: ChipGroup, resource: Resource<List<Keyword>>?) {
    view.bindResource(resource) {
        it.data.whatIfNotNullOrEmpty { keywords ->
            view.visible()
            keywords.forEach { keyword -> view.addPrimaryChip(keyword.name) }
        }
    }
}

@BindingAdapter("bindReleaseDate")
fun bindReleaseDate(view: TextView, movie: Movie) {
    view.text = "Release Date : ${movie.release_date}"
}

@BindingAdapter("bindAirDate")
fun bindAirDate(view: TextView, tv: Tv) {
    view.text = "First Air Date : ${tv.first_air_date}"
}

@BindingAdapter("bindBackDrop")
fun bindBackDrop(view: ImageView, movie: Movie) {
    if (movie.backdrop_path != null) {
        Glide.with(view.context).load(Api.getBackdropPath(movie.backdrop_path))
            .listener(view.requestGlideListener())
            .into(view)
    } else {
        Glide.with(view.context).load(Api.getBackdropPath(movie.poster_path!!))
            .listener(view.requestGlideListener())
            .into(view)
    }
}

@BindingAdapter("bindBackDrop")
fun bindBackDrop(view: ImageView, tv: Tv) {
    if (tv.backdrop_path != null) {
        Glide.with(view.context).load(Api.getBackdropPath(tv.backdrop_path))
            .listener(view.requestGlideListener())
            .into(view)
    } else if (tv.poster_path != null) {
        Glide.with(view.context).load(Api.getBackdropPath(tv.poster_path))
            .listener(view.requestGlideListener())
            .into(view)
    }
}