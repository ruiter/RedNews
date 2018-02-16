package com.ruiter.posts.data.factory

import com.ruiter.posts.list.data.models.DataResponse
import com.ruiter.posts.list.data.models.PostsListResponse

class PostsListFactory {

    companion object Factory {
        fun makeListResponse(dataResponse: DataResponse) : PostsListResponse {
            return PostsListResponse("Listing", dataResponse)
        }
    }
}