package com.ruiter.posts.list.data.mapper

import com.ruiter.posts.list.data.models.ChildrenResponse
import com.ruiter.posts.list.data.models.DataChildrenResponse
import com.ruiter.posts.list.data.models.DataParentResponse
import com.ruiter.posts.list.data.models.PostsListResponse
import com.ruiter.posts.list.domain.models.ChildrenBusinness
import com.ruiter.posts.list.domain.models.DataChildrenBusinness
import com.ruiter.posts.list.domain.models.DataParentBusinness
import com.ruiter.posts.list.domain.models.PostsListBusinness

fun PostsListResponse.toPostsListBusinness() : PostsListBusinness {
    return PostsListBusinness(kind, dataResponse.toChildrenBusinness())
}

fun ChildrenResponse.toChildrenBusinness() : ChildrenBusinness {
    return ChildrenBusinness(whitelistStatus, toMutableListDataParentBusinnes())
}

fun ChildrenResponse.toMutableListDataParentBusinnes() : MutableList<DataParentBusinness> {
    return childrenResponse.map {
        it.toDataParentBusinnes()
    }.toMutableList()
}

fun DataParentResponse.toDataParentBusinnes() : DataParentBusinness {
    return DataParentBusinness(dataChildren.toDataChildrenBusinness())
}
fun DataChildrenResponse.toDataChildrenBusinness() : DataChildrenBusinness {
    return DataChildrenBusinness(domain)
}