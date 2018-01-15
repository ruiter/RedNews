package com.ruiter.posts.list.presentation.view

import android.os.Bundle
import android.view.Menu
import com.ruiter.posts.R
import com.ruiter.posts.list.presentation.presenter.PostsListPresenter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.posts_list_layout.*
import javax.inject.Inject
import android.view.MenuItem

class PostsListActivity : DaggerAppCompatActivity(), PostsListView {

    @Inject
    lateinit var presenter: PostsListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.posts_list_layout)
        setSupportActionBar(toolbar)

        toolbar.title = "Red News"

        presenter.request()
    }

    override fun onStop() {
        super.onStop()
        presenter.destroy()
    }

    override fun showError() {
    }

    override fun hideError() {
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return true
    }
}