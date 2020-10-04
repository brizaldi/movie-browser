package com.brizaldi.moviebrowser.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.brizaldi.moviebrowser.extension.bindResource
import com.brizaldi.moviebrowser.extension.visible
import com.brizaldi.moviebrowser.models.Resource
import com.brizaldi.moviebrowser.models.Review
import com.brizaldi.moviebrowser.models.Status
import com.brizaldi.moviebrowser.models.Video
import com.brizaldi.moviebrowser.models.entity.Genre
import com.brizaldi.moviebrowser.models.entity.Movie
import com.brizaldi.moviebrowser.models.entity.Tv
import com.brizaldi.moviebrowser.view.adapter.*
import com.brizaldi.moviebrowser.view.ui.details.genre.GenreDetailActivityViewModel
import com.brizaldi.moviebrowser.view.ui.main.MainActivityViewModel
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import com.skydoves.whatif.whatIfNotNullOrEmpty

@BindingAdapter("adapter")
fun bindRecyclerViewAdapter(view: RecyclerView, adapter: BaseAdapter) {
    view.adapter = adapter
}

@BindingAdapter("adapterMovieList")
fun bindAdapterMovieList(view: RecyclerView, resource: Resource<List<Movie>>?) {
    view.bindResource(resource) {
        val adapter = view.adapter as? MovieListAdapter
        adapter?.addMovieList(it)
    }
}

@BindingAdapter("moviePagination")
fun bindMoviePagination(view: RecyclerView, viewModel: MainActivityViewModel) {
    RecyclerViewPaginator(
        recyclerView = view,
        isLoading = { viewModel.getMovieListValues()?.status == Status.LOADING },
        loadMore = { viewModel.postMoviePage(it) },
        onLast = { false }
    ).run {
        currentPage = 1
    }
}

@BindingAdapter("genreDetailMoviePagination")
fun bindGenreDetailMoviePagination(view: RecyclerView, viewModel: GenreDetailActivityViewModel) {
    RecyclerViewPaginator(
        recyclerView = view,
        isLoading = { viewModel.getMovieListValues()?.status == Status.LOADING },
        loadMore = { viewModel.postMoviePage(it) },
        onLast = { false }
    ).run {
        currentPage = 1
    }
}

@BindingAdapter("adapterGenreList")
fun bindAdapterGenreList(view: RecyclerView, resource: Resource<List<Genre>>?) {
    view.bindResource(resource) {
        val adapter = view.adapter as? GenreListAdapter
        adapter?.addGenreList(it)
    }
}

@BindingAdapter("genrePagination")
fun bindGenrePagination(view: RecyclerView, viewModel: MainActivityViewModel) {
    RecyclerViewPaginator(
        recyclerView = view,
        isLoading = { viewModel.getGenreListValues()?.status == Status.LOADING },
        loadMore = {},
        onLast = { false }
    ).run {
        currentPage = 1
    }
}

@BindingAdapter("adapterTvList")
fun bindAdapterTvList(view: RecyclerView, resource: Resource<List<Tv>>?) {
    view.bindResource(resource) {
        val adapter = view.adapter as? TvListAdapter
        adapter?.addTvList(it)
    }
}

@BindingAdapter("tvPagination")
fun bindTvPagination(view: RecyclerView, viewModel: MainActivityViewModel) {
    RecyclerViewPaginator(
        recyclerView = view,
        isLoading = { viewModel.getTvListValues()?.status == Status.LOADING },
        loadMore = { viewModel.postTvPage(it) },
        onLast = { false }
    ).run {
        currentPage = 1
    }
}

@BindingAdapter("genreDetailTvPagination")
fun bindGenreDetailTvPagination(view: RecyclerView, viewModel: GenreDetailActivityViewModel) {
    RecyclerViewPaginator(
        recyclerView = view,
        isLoading = { viewModel.getTvListValues()?.status == Status.LOADING },
        loadMore = { viewModel.postTvPage(it) },
        onLast = { false }
    ).run {
        currentPage = 1
    }
}

@BindingAdapter("adapterVideoList")
fun bindAdapterVideoList(view: RecyclerView, resource: Resource<List<Video>>?) {
    view.bindResource(resource) {
        val adapter = view.adapter as? VideoListAdapter
        adapter?.addVideoList(it)
        it.data.whatIfNotNullOrEmpty {
            view.visible()
        }
    }
}

@BindingAdapter("adapterReviewList")
fun bindAdapterReviewList(view: RecyclerView, resource: Resource<List<Review>>?) {
    view.bindResource(resource) {
        val adapter = view.adapter as? ReviewListAdapter
        adapter?.addReviewList(it)
        it.data.whatIfNotNullOrEmpty {
            view.visible()
            view.setHasFixedSize(true)
        }
    }
}