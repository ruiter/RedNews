package com.ruiter.posts.list.data.models

import com.google.gson.annotations.SerializedName

data class PostsListResponse(@SerializedName("kind")
                             val kind: String,
                             @SerializedName("data")
                             val dataResponse: DataResponse)

data class DataResponse(@SerializedName("whitelist_status")
                            val whitelistStatus: String,
                            @SerializedName("children")
                            val childrenResponse: MutableList<ChildrenResponse>)

data class ChildrenResponse(@SerializedName("data")
                        val dataChildren: DataChildrenResponse)

data class DataChildrenResponse(@SerializedName("title")
                                val title: String,
                                @SerializedName("thumbnail")
                                val thumbnail: String,
                                @SerializedName("author")
                                val author: String,
                                @SerializedName("url")
                                val url: String)