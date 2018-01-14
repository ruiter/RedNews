package com.ruiter.posts.list.data.repository

import com.ruiter.posts.list.data.entity.PostsListResponse
import com.ruiter.posts.list.data.repository.datasource.PostsListDataImpl
import io.reactivex.Single
import javax.inject.Inject

class PostsListDataRepository @Inject constructor(private val postsListDataImpl: PostsListDataImpl) {

    fun getPostsList(after: String?, limit: String) : Single<PostsListResponse> {
        return postsListDataImpl.getPostsList(after, limit)
    }
}