package com.ruiter.posts.list.domain.models

data class PostsListBusinness(val kind: String,
                              val dataBusinness: DataBusinness)

data class DataBusinness(val whitelistStatus: String,
                         val childrenResponse: MutableList<ChildrenBusinness>)

data class ChildrenBusinness(val dataChildren: DataChildrenBusinness)

data class DataChildrenBusinness(val domain: String)