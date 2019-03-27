package com.ruiter.network.posts.models

import com.google.gson.annotations.SerializedName

/**
 * Created by ruitermatos on 21/03/18.
 */
data class PostsListRemote(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("data")
    val dataRemote: DataRemote
)

data class DataRemote(
    @SerializedName("children")
    val childrenRemote: MutableList<ChildrenRemote>,
    @SerializedName("after")
    val after: String?
)

data class ChildrenRemote(@SerializedName("data") val dataChildren: DataChildrenRemote)

data class DataChildrenRemote(
    @SerializedName("title")
    val title: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("ups")
    val likes: String,
    @SerializedName("num_comments")
    val comments: String,
    @SerializedName("preview")
    val preview: PreviewRemote?
)

data class PreviewRemote(@SerializedName("images") val images: MutableList<ImagesRemote>)

data class ImagesRemote(
    @SerializedName("source")
    val source: SourceRemote,
    @SerializedName("resolutions")
    val resolutions: MutableList<ResolutionsRemote>
)

data class SourceRemote(
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int
)

data class ResolutionsRemote(
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int
)