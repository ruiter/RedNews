package com.ruiter.posts.list.presentation.view.adapter.viewholders

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ruiter.posts.list.presentation.model.Children
import com.ruiter.posts.list.presentation.model.Resolutions
import com.ruiter.posts.utils.Utils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_posts_list.view.*

class PostsListViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    lateinit var resolution: Resolutions

    fun bind(childreList: MutableList<Children>, position: Int, context: Context) = with(itemView) {
        tvSubTitle.text = "Submitted by " + childreList[position].dataChildren.author
        tvTitle.text = childreList[position].dataChildren.title

        if(childreList[position].dataChildren.preview != null) {
            resolution = Utils(context).getBestResolutionImage(context, childreList[position].dataChildren.preview!!.images)

            if (resolution.url != "") {
                Picasso.with(context)
                        .load(resolution.url)
                        .into(ivMain)
            }
        }

        tvLikes.text = childreList[position].dataChildren.likes
        tvComments.text = childreList[position].dataChildren.comments
    }
}