package com.ruiter.posts.list.presentation.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ruiter.posts.R
import com.ruiter.posts.list.presentation.model.Children
import com.ruiter.posts.list.presentation.model.PostsList
import com.ruiter.posts.list.presentation.view.adapter.viewholders.PostsListViewHolder
import com.ruiter.posts.list.presentation.view.adapter.viewholders.ProgressViewHolder

class PostsListAdapter constructor(val context: Context, private val postsList: PostsList): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var childrenList: MutableList<Children>

    companion object {
        const val VIEW_ITEM = 1
        const val VIEW_PROG = 0
    }

    fun setList() {
        childrenList = postsList.dataResponse.childrenResponse
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder?.itemViewType == VIEW_ITEM) {
            val holderPosts = holder as PostsListViewHolder
            holderPosts.bind(childrenList, position, context)
        } else  if (holder?.itemViewType == VIEW_PROG) {
            val holderPosts = holder as ProgressViewHolder
            holderPosts.bind()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        if (viewType == VIEW_ITEM) {
            val v = LayoutInflater.from(
                    parent?.context).inflate(R.layout.card_posts_list, parent, false)

            return PostsListViewHolder(v)
        } else if (viewType == VIEW_PROG) {
            val v = LayoutInflater.from(
                    parent?.context).inflate(R.layout.progress_loading, parent, false)

            return ProgressViewHolder(v, v.findViewById(R.id.progressBar))
        }

        return null
    }

    override fun getItemCount(): Int {
        return childrenList.size
    }

    override fun getItemViewType(position: Int): Int {
       // val mFretesList = list!![position]

//        if (childrenList[position] == null && !erroConexao) {
//            return VIEW_PROG
//        }

        return VIEW_ITEM
    }

}