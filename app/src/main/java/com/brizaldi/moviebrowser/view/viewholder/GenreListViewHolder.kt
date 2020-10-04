package com.brizaldi.moviebrowser.view.viewholder

import android.view.View
import com.brizaldi.moviebrowser.models.entity.Genre
import com.brizaldi.moviebrowser.view.ui.details.genre.GenreDetailActivity
import com.skydoves.baserecyclerviewadapter.BaseViewHolder
import kotlinx.android.synthetic.main.item_genre.view.*

class GenreListViewHolder constructor(
    val view: View
) : BaseViewHolder(view) {

    private lateinit var genre: Genre

    @Throws(Exception::class)
    override fun bindData(data: Any) {
        if (data is Genre) {
            genre = data
            drawItem()
        }
    }

    private fun drawItem() {
        itemView.run {
            item_genre_name.text = genre.name
        }
    }

    override fun onClick(p0: View?) = GenreDetailActivity.startActivityModel(context(), genre)

    override fun onLongClick(p0: View?) = false
}