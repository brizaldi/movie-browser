package com.brizaldi.moviebrowser.view.viewholder

import android.view.View
import com.brizaldi.moviebrowser.models.Review
import com.skydoves.baserecyclerviewadapter.BaseViewHolder
import kotlinx.android.synthetic.main.item_review.view.*

class ReviewListViewHolder(val view: View) : BaseViewHolder(view) {

    private lateinit var review: Review

    override fun bindData(data: Any) {
        if (data is Review) {
            review = data
            drawItem()
        }
    }

    private fun drawItem() {
        itemView.run {
            item_review_title.text = review.author
            item_review_content.text = review.content
        }
    }

    override fun onClick(v: View?) = Unit

    override fun onLongClick(v: View?) = false
}