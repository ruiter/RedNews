package com.ruiter.posts.list.presentation.view

import com.ruiter.posts.list.presentation.model.PostsList

interface PostsListView {

    fun showError()
    fun hideError()
    fun setAdapter(postsList: PostsList)
}