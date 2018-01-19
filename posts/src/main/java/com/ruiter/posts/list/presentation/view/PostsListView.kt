package com.ruiter.posts.list.presentation.view

import com.ruiter.posts.list.presentation.models.PostsList

interface PostsListView {

    fun showProgress()
    fun hideProgress()
    fun showError()
    fun hideError()
    fun setAdapter(postsList: PostsList)
    fun request(bool: Boolean)
}