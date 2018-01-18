package com.ruiter.posts.list.domain.models

data class PostsListBusinness(val kind: String,
                              val dataBusinness: DataBusinness)

data class DataBusinness(val whitelistStatus: String,
                         val childrenResponse: MutableList<ChildrenBusinness>,
                         val after: String?)

data class ChildrenBusinness(val dataChildren: DataChildrenBusinness)

data class DataChildrenBusinness(val title: String,
                                 val thumbnail: String,
                                 val author: String,
                                 val url: String,
                                 val likes: String,
                                 val comments: String,
                                 val preview: PreviewBusinnes?)

data class PreviewBusinnes(val images: MutableList<ImagesBusinnes>)

data class ImagesBusinnes(val source: SourceBusinnes,
                          val resolutions: MutableList<ResolutionsBusinnes>)

data class SourceBusinnes(val url: String,
                          val width: Int,
                          val height: Int)

data class ResolutionsBusinnes(val url: String,
                               val width: Int,
                               val height: Int)