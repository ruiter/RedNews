package com.ruiter.posts.list.data.repository.source

import com.ruiter.posts.list.data.models.PostsListResponse
import io.reactivex.Single
import javax.inject.Inject

class PostsListDataStoreImpl @Inject constructor(private val dataStore: PostsListDataStore)
    : PostsListDataStore {

    override fun getPostsList(after: String?, limit: String): Single<PostsListResponse> {
        return dataStore.getPostsList(after, limit)
    }
}