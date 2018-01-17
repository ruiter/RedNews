package com.ruiter.posts.list.data.repository.source

import com.ruiter.posts.list.data.models.PostsListResponse
import com.ruiter.posts.list.data.net.PostsListService
import io.reactivex.Single
import javax.inject.Inject

class PostsListDataImpl @Inject constructor(private val service: PostsListService) : PostsListData {
    override fun getPostsList(after: String?, limit: String) : Single<PostsListResponse> {
        return service.getPostsList(after, limit, "1")
    }
}