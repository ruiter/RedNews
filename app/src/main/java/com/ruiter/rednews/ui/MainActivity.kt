package com.ruiter.rednews.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ruiter.posts.list.presentation.view.PostsListActivity
import com.ruiter.rednews.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, PostsListActivity::class.java))
    }
}
