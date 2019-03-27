package com.ruiter.posts.list.data.models

data class PostsListResponse(val kind: String, val dataResponse: DataResponse)

data class DataResponse(
    val childrenResponse: MutableList<ChildrenResponse>,
    val after: String?
)

data class ChildrenResponse(val dataChildren: DataChildrenResponse)

data class DataChildrenResponse(
    val title: String,
    val thumbnail: String,
    val author: String,
    val url: String,
    val likes: String,
    val comments: String,
    val preview: PreviewResponse?
)

data class PreviewResponse(val images: MutableList<ImagesResponse>)

data class ImagesResponse(val source: SourceResponse, val resolutions: MutableList<ResolutionsResponse>)

data class SourceResponse(val url: String, val width: Int, val height: Int)

data class ResolutionsResponse(val url: String, val width: Int, val height: Int)