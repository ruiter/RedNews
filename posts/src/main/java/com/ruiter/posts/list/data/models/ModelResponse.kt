package com.ruiter.posts.list.data.models

import com.google.gson.annotations.SerializedName

data class PostsListResponse(@SerializedName("kind")
                             val kind: String,
                             @SerializedName("data")
                             val dataResponse: ChildrenResponse)

data class ChildrenResponse(@SerializedName("whitelist_status")
                            val whitelistStatus: String,
                            @SerializedName("children")
                            val childrenResponse: MutableList<DataParentResponse>)

data class DataParentResponse(@SerializedName("data")
                        val dataChildren: DataChildrenResponse)

data class DataChildrenResponse(@SerializedName("domain")
                        val domain: String)