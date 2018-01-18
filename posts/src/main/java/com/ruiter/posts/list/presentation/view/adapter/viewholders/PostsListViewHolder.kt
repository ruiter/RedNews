package com.ruiter.posts.list.presentation.view.adapter.viewholders

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.ruiter.posts.list.presentation.model.Children
import com.ruiter.posts.list.presentation.model.Resolutions
import com.ruiter.posts.utils.getBestResolutionImage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_posts_list.view.*

class PostsListViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(childreList: MutableList<Children>, position: Int, context: Context) = with(itemView) {
        val resolution: Resolutions?

        tvSubTitle.text = "Submitted by " + childreList[position].dataChildren.author
        tvTitle.text = childreList[position].dataChildren.title

        if(childreList[position].dataChildren.thumbnail != "self"
                || childreList[position].dataChildren.thumbnail != "default") {

            resolution = childreList[position].dataChildren.preview?.images?.let { getBestResolutionImage(context, it) }

            if (resolution?.url != "") {
                ivMain.visibility = View.VISIBLE

                Picasso.with(context)
                        .load(resolution?.url)
                        .into(ivMain)
            } else {
                ivMain.visibility = View.GONE
            }
        }

        tvLikes.text = childreList[position].dataChildren.likes + " likes"
        tvComments.text = childreList[position].dataChildren.comments + " comments"
    }
}