package com.ruiter.posts.utils

import android.content.Context
import android.widget.ImageView
import com.ruiter.posts.list.presentation.models.Images
import com.ruiter.posts.list.presentation.models.Resolutions
import com.squareup.picasso.Picasso

/**
 * reference
    density 0.75 if it's LDPI
    density 1.0 if it's MDPI
    density 1.5 if it's HDPI
    density 2.0 if it's XHDPI
    density 3.0 if it's XXHDPI
    density 4.0 if it's XXXHDPI

    xlarge (xhdpi): 640x960
    large (hdpi): 480x800
    medium (mdpi): 320x480
    small (ldpi): 240x320
 */

fun getBestResolutionImage(context: Context, imageList: MutableList<Images>) : Resolutions? {

    val density = context.resources.displayMetrics.density
    var res = Resolutions("", 0, 0)

    if (density == 1.5f || density == 2.0f || density == 3.0f || density == 4.0f) {
        res = filterResolutions(640, imageList[0].resolutions)
    } else if(density == 1.0f) {
        res = filterResolutions(320, imageList[0].resolutions)
    } else if(density == 0.75f) {
        res = filterResolutions(216, imageList[0].resolutions)
    }

    return res
}

fun filterResolutions(value: Int, resolutions: MutableList<Resolutions>): Resolutions {

    return resolutions
            .firstOrNull { it.width == value }
            ?.let { Resolutions(it.url, it.width, it.height) }
            ?: Resolutions("", 0, 0)
}

fun ImageView.loadUrl(url: String?) {
    Picasso.with(context).load(url).into(this)
}