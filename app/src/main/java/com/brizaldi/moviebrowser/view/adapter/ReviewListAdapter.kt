package com.brizaldi.moviebrowser.view.adapter

import android.view.View
import com.brizaldi.moviebrowser.R
import com.brizaldi.moviebrowser.models.Resource
import com.brizaldi.moviebrowser.models.Review
import com.brizaldi.moviebrowser.view.viewholder.ReviewListViewHolder
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow
import com.skydoves.whatif.whatIfNotNull

class ReviewListAdapter : BaseAdapter() {

    init {
        addSection(ArrayList<Review>())
    }

    fun addReviewList(resource: Resource<List<Review>>) {
        resource.data.whatIfNotNull {
            sections()[0].addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_review

    override fun viewHolder(layout: Int, view: View) = ReviewListViewHolder(view)
}