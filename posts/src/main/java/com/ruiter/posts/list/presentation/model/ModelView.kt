package com.ruiter.posts.list.presentation.model

data class PostsList(val kind: String, val dataResponse: Data)

data class Data(val whitelistStatus: String, val childrenResponse: MutableList<Children>)

data class Children(val dataChildren: DataChildren)

data class DataChildren(val domain: String)