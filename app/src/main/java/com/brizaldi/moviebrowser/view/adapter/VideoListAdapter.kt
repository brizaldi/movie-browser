package com.brizaldi.moviebrowser.view.adapter

import android.view.View
import com.brizaldi.moviebrowser.R
import com.brizaldi.moviebrowser.models.Resource
import com.brizaldi.moviebrowser.models.Video
import com.brizaldi.moviebrowser.view.viewholder.VideoListViewHolder
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow
import com.skydoves.whatif.whatIfNotNull

class VideoListAdapter : BaseAdapter() {

    init {
        addSection(ArrayList<Video>())
    }

    fun addVideoList(resource: Resource<List<Video>>) {
        resource.data.whatIfNotNull {
            sections()[0].addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_video

    override fun viewHolder(layout: Int, view: View) = VideoListViewHolder(view)
}