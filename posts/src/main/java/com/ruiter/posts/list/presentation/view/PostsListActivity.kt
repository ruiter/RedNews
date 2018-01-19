package com.ruiter.posts.list.presentation.view

import android.os.Bundle
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
import android.view.View
import com.ruiter.posts.list.presentation.models.PostsList
import kotlinx.android.synthetic.main.offline.*
import kotlinx.android.synthetic.main.progress_list.*
import android.view.animation.AnimationUtils

class PostsListActivity : DaggerAppCompatActivity(), PostsListView {

    @Inject
    lateinit var presenter: PostsListPresenter

    private var adapter: PostsListAdapter? = null

    private val linearManager = LinearLayoutManager(this)
    private val staggeredManager = StaggeredGridLayoutManager(2,
            StaggeredGridLayoutManager.VERTICAL)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.posts_list_layout)
        setSupportActionBar(toolbar)

        toolbar.title = "Red News"

        val resId = R.anim.layout_anim_from_recyclerview
        val animation = AnimationUtils.loadLayoutAnimation(this, resId)

        recyclerview.layoutAnimation = animation
        setLayoutManager()

        tvButtonOffline.setOnClickListener{
            request(false)
        }

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
            adapter?.addNews(postsList)
        } else {
            adapter = PostsListAdapter(this, postsList)
            adapter?.setList()
            adapter?.setRecyclerviewListener(recyclerview, this)
            recyclerview.adapter = adapter
            runLayoutAnimation()
        }

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

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun showProgress() {
        recyclerview.visibility = View.GONE
        llProgressList.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        llProgressList.visibility = View.GONE
        recyclerview.visibility = View.VISIBLE
    }

    override fun showError() {
        llProgressList.visibility = View.GONE
        recyclerview.visibility = View.GONE
        llOffline.visibility = View.VISIBLE
    }

    override fun hideError() {
        llOffline.visibility = View.GONE
        llProgressList.visibility = View.VISIBLE
    }

    private fun runLayoutAnimation() {
        recyclerview.layoutAnimation = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_anim_from_recyclerview)
        recyclerview.adapter.notifyDataSetChanged()
        recyclerview.scheduleLayoutAnimation()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.update -> {
                request(false)
            }
        }
        return true
    }
}