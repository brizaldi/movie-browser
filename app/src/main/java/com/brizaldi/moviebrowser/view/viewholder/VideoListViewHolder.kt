package com.brizaldi.moviebrowser.view.viewholder

import android.content.Intent
import android.net.Uri
import android.view.View
import com.brizaldi.moviebrowser.api.Api
import com.brizaldi.moviebrowser.models.Video
import com.bumptech.glide.Glide
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.skydoves.baserecyclerviewadapter.BaseViewHolder
import kotlinx.android.synthetic.main.item_video.view.*

class VideoListViewHolder constructor(
    val view: View
) : BaseViewHolder(view) {

    private lateinit var video: Video

    override fun bindData(data: Any) {
        if (data is Video) {
            video = data
            drawItem()
        }
    }

    private fun drawItem() {
        itemView.run {
            item_video_title.text = video.name
            Glide.with(context)
                .load(Api.getYoutubeThumbnailPath(video.key))
                .listener(
                    GlidePalette.with(Api.getYoutubeThumbnailPath(video.key))
                    .use(BitmapPalette.Profile.VIBRANT)
                    .intoBackground(item_video_palette)
                    .crossfade(true))
                .into(item_video_cover)
        }
    }

    override fun onClick(v: View?) =
        context().startActivity(
            Intent(Intent.ACTION_VIEW, Uri.parse(Api.getYoutubeVideoPath(video.key)))
        )

    override fun onLongClick(v: View?) = false
}