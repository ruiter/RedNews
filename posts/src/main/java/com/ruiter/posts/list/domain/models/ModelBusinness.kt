package com.ruiter.posts.list.domain.models

data class PostsListBusinness(val kind: String,
                              val dataResponse: ChildrenBusinness)

data class ChildrenBusinness(val whitelistStatus: String,
                             val childrenResponse: MutableList<DataParentBusinness>)

data class DataParentBusinness(val dataChildren: DataChildrenBusinness)

data class DataChildrenBusinness(val domain: String)