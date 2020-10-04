package com.brizaldi.moviebrowser.view.adapter

import android.view.View
import com.brizaldi.moviebrowser.R
import com.brizaldi.moviebrowser.models.Resource
import com.brizaldi.moviebrowser.models.entity.Movie
import com.brizaldi.moviebrowser.view.viewholder.MovieListViewHolder
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow
import com.skydoves.whatif.whatIfNotNull

class MovieListAdapter : BaseAdapter() {

    init {
        addSection(ArrayList<Movie>())
    }

    fun addMovieList(resource: Resource<List<Movie>>) {
        resource.data.whatIfNotNull {
            sections()[0].addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_poster

    override fun viewHolder(layout: Int, view: View) = MovieListViewHolder(view)
}