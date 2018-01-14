package com.ruiter.posts.list.presentation.view

import android.os.Bundle
import com.ruiter.posts.R
import com.ruiter.posts.list.presentation.presenter.PostsListPresenter
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class PostsListActivity : DaggerAppCompatActivity(), PostsListView {
    override fun showError() {
    }

    override fun hideError() {
    }

    @Inject
    lateinit var presenter: PostsListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.rednewsact_layout)
    }
}