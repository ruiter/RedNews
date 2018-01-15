package com.ruiter.posts.list.presentation.mapper

import com.ruiter.posts.list.domain.models.ChildrenBusinness
import com.ruiter.posts.list.domain.models.DataBusinness
import com.ruiter.posts.list.domain.models.DataChildrenBusinness
import com.ruiter.posts.list.domain.models.PostsListBusinness
import com.ruiter.posts.list.presentation.model.*

fun PostsListBusinness.toPostsList() : PostsList {
    return PostsList(kind, dataBusinness.toChildren())
}

fun DataBusinness.toChildren() : Data {
    return Data(whitelistStatus, toMutableListDataParent())
}

fun DataBusinness.toMutableListDataParent() : MutableList<Children> {
    return childrenResponse.map {
        it.toDataParent()
    }.toMutableList()
}

fun ChildrenBusinness.toDataParent() : Children {
    return Children(dataChildren.toDataChildren())
}

fun DataChildrenBusinness.toDataChildren() : DataChildren {
    return DataChildren(title, thumbnail, author, url)
}