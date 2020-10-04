package com.brizaldi.moviebrowser.view.adapter

import android.view.View
import com.brizaldi.moviebrowser.R
import com.brizaldi.moviebrowser.models.Resource
import com.brizaldi.moviebrowser.models.entity.Genre
import com.brizaldi.moviebrowser.view.viewholder.GenreListViewHolder
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow
import com.skydoves.whatif.whatIfNotNull

class GenreListAdapter : BaseAdapter() {

    init {
        addSection(ArrayList<Genre>())
    }

    fun addGenreList(resource: Resource<List<Genre>>) {
        resource.data.whatIfNotNull {
            sections()[0].addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_genre

    override fun viewHolder(layout: Int, view: View) = GenreListViewHolder(view)
}