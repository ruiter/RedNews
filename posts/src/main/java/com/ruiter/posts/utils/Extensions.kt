package com.ruiter.posts.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by ruitermatos on 12/03/18.
 */
fun ImageView.loadUrl(url: String?) {
    Picasso.with(context).load(url).into(this)
}