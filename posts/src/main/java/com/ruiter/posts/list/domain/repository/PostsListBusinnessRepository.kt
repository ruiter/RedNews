package com.ruiter.posts.list.domain.repository

import com.ruiter.posts.list.domain.models.DataRequestResponse
import com.ruiter.posts.list.domain.models.PostsListBusinness
import io.reactivex.Single

interface PostsListBusinnessRepository {
    fun getPostsList(dataParentBusinness: DataRequestResponse) : Single<PostsListBusinness>
}