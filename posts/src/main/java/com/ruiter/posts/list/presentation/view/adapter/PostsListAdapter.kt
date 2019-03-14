package com.ruiter.posts.list.presentation.view.adapter

import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ruiter.posts.R
import com.ruiter.posts.list.presentation.models.Children
import com.ruiter.posts.list.presentation.models.PostsList
import com.ruiter.posts.list.presentation.view.adapter.viewholders.PostsListViewHolder
import com.ruiter.posts.list.presentation.view.adapter.viewholders.ProgressViewHolder
import android.support.v7.widget.StaggeredGridLayoutManager
import com.ruiter.posts.list.presentation.view.PostsListView

class PostsListAdapter constructor(private val context: Activity,
                                   private val postsList: PostsList)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var childrenList: MutableList<Children>

    private var visibleItemCount: Int = 0
    private var totalItemCount: Int = 0
    private var pastVisibleItems: Int = 0
    private var loading: Boolean = true

    companion object {
        const val VIEW_ITEM = 1
        const val VIEW_PROG = 0
    }

    fun setList() {
        childrenList = postsList.dataResponse.childrenResponse
    }

    fun setLoaded() {
        loading = true
    }

    fun setRecyclerviewListener(recyclerView: RecyclerView, view: PostsListView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    visibleItemCount = recyclerView.layoutManager!!.childCount
                    totalItemCount = recyclerView.layoutManager!!.itemCount

                    // Verify if the device is tablet, because if is tablet the list is gridview
                    if (recyclerView.layoutManager is StaggeredGridLayoutManager) {
                        var firstVisibleItems: IntArray? = null
                        firstVisibleItems = (recyclerView
                                .layoutManager as StaggeredGridLayoutManager).findFirstCompletelyVisibleItemPositions(
                                firstVisibleItems)

                        if (firstVisibleItems != null && firstVisibleItems.size > 0) {
                            pastVisibleItems = firstVisibleItems[0]
                        }
                    } else {
                        pastVisibleItems = (recyclerView
                                .layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    }


                    if (loading) {

                        if (visibleItemCount + pastVisibleItems >= totalItemCount) {
                            loading = false
                            view.request(true)
                        }
                    }
                }
            }
        })
    }

    fun addNews(postsList: PostsList) {
        childrenList.removeAt(childrenList.size - 1)
        notifyItemRemoved(childrenList.size)
        childrenList.addAll(postsList.dataResponse.childrenResponse)
        notifyItemInserted(childrenList.size)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == VIEW_ITEM) {
            val holderPosts = holder as PostsListViewHolder
            holderPosts.bind(childrenList, position, context)
        } else  if (holder.itemViewType == VIEW_PROG) {
            val holderPosts = holder as ProgressViewHolder
            holderPosts.bind()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(
            parent.context).inflate(R.layout.card_posts_list, parent, false)
        if (viewType == VIEW_ITEM) {
            val v1 = LayoutInflater.from(
                    parent.context).inflate(R.layout.card_posts_list, parent, false)

            return PostsListViewHolder(v1)
        } else if (viewType == VIEW_PROG) {
            val v2 = LayoutInflater.from(
                    parent.context).inflate(R.layout.progress_loading, parent, false)

            return ProgressViewHolder(v2, v2.findViewById(R.id.progressBar))
        }

        return PostsListViewHolder(v)
    }

    override fun getItemCount(): Int {
        return childrenList.size
    }

    private fun isPositionItem(position: Int): Boolean {
        return position == itemCount - 1
    }

    override fun getItemViewType(position: Int): Int {

        if (isPositionItem(position)) {
            return VIEW_PROG
        }

        return VIEW_ITEM
    }
}