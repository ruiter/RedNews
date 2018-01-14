package com.ruiter.posts.list.data.repository.datasource

import android.util.Log
import com.ruiter.posts.list.data.entity.PostsListResponse
import com.ruiter.posts.list.data.net.PostsListService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostsListDataImpl @Inject constructor(private val service: PostsListService) : PostsListData {
    override fun getPostsList(after: String?, limit: String) : Single<PostsListResponse> {
        return service.getPostsList(after, limit)
    }
}