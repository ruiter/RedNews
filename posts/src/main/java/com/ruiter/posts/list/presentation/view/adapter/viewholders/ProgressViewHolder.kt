package com.ruiter.posts.list.presentation.view.adapter.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar

class ProgressViewHolder constructor(itemView: View, private val progressBar: ProgressBar)
    : RecyclerView.ViewHolder(itemView) {

    fun bind() = with(itemView) {
        progressBar.isIndeterminate = true
    }
}