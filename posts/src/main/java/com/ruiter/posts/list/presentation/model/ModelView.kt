package com.ruiter.posts.list.presentation.model

data class PostsList(val kind: String, val dataResponse: Children)

data class Children(val whitelistStatus: String, val childrenResponse: MutableList<DataParent>)

data class DataParent(val dataChildren: DataChildren)

data class DataChildren(val domain: String)