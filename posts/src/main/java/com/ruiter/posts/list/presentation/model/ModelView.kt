package com.ruiter.posts.list.presentation.model

data class PostsList(val kind: String, val dataResponse: Data)

data class Data(val whitelistStatus: String, val childrenResponse: MutableList<Children>)

data class Children(val dataChildren: DataChildren)

data class DataChildren(val title: String,
                        val thumbnail: String,
                        val author: String,
                        val url: String,
                        val likes: String,
                        val comments: String,
                        val preview: Preview?)

data class Preview(val images: MutableList<Images>)

data class Images(val source: Source,
                          val resolutions: MutableList<Resolutions>)

data class Source(val url: String,
                          val width: Int,
                          val height: Int)

data class Resolutions(val url: String,
                               val width: Int,
                               val height: Int)