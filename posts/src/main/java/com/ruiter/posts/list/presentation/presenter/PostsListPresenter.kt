package com.ruiter.posts.list.presentation.presenter

import android.util.Log
import com.ruiter.posts.list.presentation.view.PostsListView
import javax.inject.Inject

class PostsListPresenter @Inject constructor(val view: PostsListView) : Presenter {
    override fun destroy() {
        Log.i("ruiter", "destroy presenter")
    }
}