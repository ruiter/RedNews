package com.ruiter.posts.list.presentation.view

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.view.Menu
import com.ruiter.posts.R
import com.ruiter.posts.list.presentation.presenter.PostsListPresenter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.posts_list_layout.*
import javax.inject.Inject
import android.view.MenuItem
import com.ruiter.posts.list.presentation.view.adapter.PostsListAdapter
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.ruiter.posts.list.presentation.model.PostsList

class PostsListActivity : DaggerAppCompatActivity(), PostsListView {

    @Inject
    lateinit var presenter: PostsListPresenter

    var adapter: PostsListAdapter? = null

    val linearManager = LinearLayoutManager(this)
    val staggeredManager = StaggeredGridLayoutManager(2,
            StaggeredGridLayoutManager.VERTICAL)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.posts_list_layout)
        setSupportActionBar(toolbar)

        toolbar.title = "Red News"

        recyclerview.itemAnimator = DefaultItemAnimator()
        setLayoutManager()

        request(false)
    }

    override fun request(bool: Boolean) {
        if (!bool) {
            adapter = null
        }

        presenter.request(bool)
    }

    override fun setAdapter(postsList: PostsList) {
        if (adapter != null) {
            Log.i("ruiter", "addNews " + postsList.dataResponse)
            adapter?.addNews(postsList)
        } else {
            adapter = PostsListAdapter(this, postsList)
            adapter?.setList()
            adapter?.setRecyclerviewListener(recyclerview, this)
            recyclerview.adapter = adapter
        }
        Log.i("ruiter", "adapter " + adapter)
        adapter?.setLoaded()
    }

    private fun setLayoutManager() {
        val isPhone = resources.getBoolean(R.bool.is_phone)

        if (isPhone) {
            recyclerview.layoutManager = linearManager
        } else {
            recyclerview.layoutManager = staggeredManager
        }

    }

    override fun onStop() {
        super.onStop()
        presenter.destroy()
    }

    override fun onDestroy() {
        super.onDestroy()
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