package com.ruiter.posts.list.presentation.mapper

import com.ruiter.posts.list.domain.models.ChildrenBusinness
import com.ruiter.posts.list.domain.models.DataChildrenBusinness
import com.ruiter.posts.list.domain.models.DataParentBusinness
import com.ruiter.posts.list.domain.models.PostsListBusinness
import com.ruiter.posts.list.presentation.model.Children
import com.ruiter.posts.list.presentation.model.DataChildren
import com.ruiter.posts.list.presentation.model.DataParent
import com.ruiter.posts.list.presentation.model.PostsList

fun PostsListBusinness.toPostsList() : PostsList {
    return PostsList(kind, dataResponse.toChildren())
}

fun ChildrenBusinness.toChildren() : Children {
    return Children(whitelistStatus, toMutableListDataParent())
}

fun ChildrenBusinness.toMutableListDataParent() : MutableList<DataParent> {
    return childrenResponse.map {
        it.toDataParent()
    }.toMutableList()
}

fun DataParentBusinness.toDataParent() : DataParent {
    return DataParent(dataChildren.toDataChildren())
}

fun DataChildrenBusinness.toDataChildren() : DataChildren {
    return DataChildren(domain)
}