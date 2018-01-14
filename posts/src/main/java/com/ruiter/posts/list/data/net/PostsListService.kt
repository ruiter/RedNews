package com.ruiter.posts.list.data.net

import com.ruiter.posts.list.data.entity.PostsListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PostsListService {

    @GET("new.json")
    fun getPostsList(
            @Query("after") after: String?,
            @Query("limit") limit: String
    ) : Single<PostsListResponse>
}