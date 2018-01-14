package com.ruiter.posts.list.data.repository.source

import com.ruiter.posts.list.data.models.PostsListResponse
import io.reactivex.Single

interface PostsListData {

    fun getPostsList(after: String?, limit: String) : Single<PostsListResponse>
}