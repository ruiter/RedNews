package com.ruiter.posts.list.data.models

import com.google.gson.annotations.SerializedName

data class PostsListResponse(@SerializedName("kind")
                             val kind: String,

                             @SerializedName("data")
                             val dataResponse: DataResponse)

data class DataResponse(@SerializedName("whitelist_status")
                        val whitelistStatus: String,

                        @SerializedName("children")
                        val childrenResponse: MutableList<ChildrenResponse>,

                        @SerializedName("after")
                        val after: String?)

data class ChildrenResponse(@SerializedName("data")
                            val dataChildren: DataChildrenResponse)

data class DataChildrenResponse(@SerializedName("title")
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
                                val preview: PreviewResponse?)

data class PreviewResponse(@SerializedName("images")
                           val images: MutableList<ImagesResponse>)

data class ImagesResponse(@SerializedName("source")
                          val source: SourceResponse,

                          @SerializedName("resolutions")
                            val resolutions: MutableList<ResolutionsResponse>)

data class SourceResponse(@SerializedName("url")
                          val url: String,

                          @SerializedName("width")
                          val width: Int,

                          @SerializedName("height")
                          val height: Int)

data class ResolutionsResponse(@SerializedName("url")
                               val url: String,

                               @SerializedName("width")
                               val width: Int,

                               @SerializedName("height")
                               val height: Int)