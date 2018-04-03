package com.ruiter.network.posts.mapper

import com.ruiter.network.Mapper
import com.ruiter.network.posts.models.PostsListRemote
import com.ruiter.posts.list.data.models.PostsListResponse

/**
 * Created by ruitermatos on 21/03/18.
 */
class PostsMapperImpl : Mapper<PostsListRemote, PostsListResponse> {

    override fun mapFromNetwork(type: PostsListRemote): PostsListResponse {
        return PostsListResponse(type.kind, type.dataRemote.toChildrenResponse())
    }
}