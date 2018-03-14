package com.ruiter.posts.data.factory

import com.nhaarman.mockito_kotlin.whenever
import com.ruiter.posts.list.data.models.DataResponse
import com.ruiter.posts.list.data.models.PostsListResponse
import com.ruiter.posts.list.data.net.PostsListService
import io.reactivex.Single

class PostsListFactory {

    companion object Factory {
        fun makeListResponse(dataResponse: DataResponse) : PostsListResponse {
            return PostsListResponse("Listing", dataResponse)
        }

        fun listServiceGetSingle(single: Single<PostsListResponse>,
                                         service: PostsListService,
                                         after: String?,
                                         limit: String,
                                         raw: String) {
            whenever(service.getPostsList(after, limit, raw))
                    .thenReturn(single)
        }
    }
}