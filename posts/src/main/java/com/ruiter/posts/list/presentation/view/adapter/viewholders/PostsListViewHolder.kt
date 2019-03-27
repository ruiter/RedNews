package com.ruiter.posts.list.presentation.view.adapter.viewholders

import android.app.Activity
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ruiter.posts.list.presentation.models.Children
import com.ruiter.posts.list.presentation.models.Resolutions
import com.ruiter.posts.utils.getBestResolutionImage
import kotlinx.android.synthetic.main.card_posts_list.view.*
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import com.ruiter.posts.R
import com.ruiter.posts.utils.loadUrl

class PostsListViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(childreList: MutableList<Children>, position: Int, context: Activity) = with(itemView) {
        val resolution: Resolutions?

        tvSubTitle.text = "Submitted by " + childreList[position].dataChildren.author
        tvTitle.text = childreList[position].dataChildren.title

        if(childreList[position].dataChildren.thumbnail != "self"
                || childreList[position].dataChildren.thumbnail != "default") {

            resolution = childreList[position].dataChildren.preview?.images?.let { getBestResolutionImage(context, it) }

            if (resolution?.url != "") {
                ivMain.visibility = View.VISIBLE
                val url = resolution?.url

                ivMain.loadUrl(url)
            } else {
                ivMain.visibility = View.GONE
            }
        }

        tvLikes.text = childreList[position].dataChildren.likes + " likes"
        tvComments.text = childreList[position].dataChildren.comments + " comments"

        llHeader.setOnClickListener{
            if (childreList[position].dataChildren.url != "") {
                openUrl(childreList[position].dataChildren.url, context)
            }
        }
    }

    private fun openUrl(url: String, context: Activity) {
        val intentBuilder = CustomTabsIntent.Builder()

        intentBuilder.setStartAnimations(context, R.anim.start_in_right, R.anim.start_out_left)
        intentBuilder.setExitAnimations(context, R.anim.start_in_left, R.anim.start_out_right)
        intentBuilder.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary))
        val customTabsIntent = intentBuilder.build()
        customTabsIntent.launchUrl(context, Uri.parse(url))
    }
}