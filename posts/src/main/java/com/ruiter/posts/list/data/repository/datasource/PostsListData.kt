package com.ruiter.posts.list.data.repository.datasource

import com.ruiter.posts.list.data.entity.PostsListResponse
import io.reactivex.Single

interface PostsListData {

    fun getPostsList(after: String?, limit: String) : Single<PostsListResponse>
}