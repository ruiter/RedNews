package com.ruiter.posts.list.data.mapper

import com.ruiter.posts.list.data.models.*
import com.ruiter.posts.list.domain.models.*

fun PostsListResponse.toPostsListBusinness() : PostsListBusinness {
    return PostsListBusinness(kind, dataResponse.toChildrenBusinness())
}

fun DataResponse.toChildrenBusinness() : DataBusinness {
    return DataBusinness(whitelistStatus, toMutableListDataParentBusinnes())
}

fun DataResponse.toMutableListDataParentBusinnes() : MutableList<ChildrenBusinness> {
    return childrenResponse.map {
        it.toDataParentBusinnes()
    }.toMutableList()
}

fun ChildrenResponse.toDataParentBusinnes() : ChildrenBusinness {
    return ChildrenBusinness(dataChildren.toDataChildrenBusinness())
}
fun DataChildrenResponse.toDataChildrenBusinness() : DataChildrenBusinness {
    return DataChildrenBusinness(domain)
}