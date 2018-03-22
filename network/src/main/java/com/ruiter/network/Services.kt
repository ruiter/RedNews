package com.ruiter.network

import com.ruiter.network.posts.models.PostsListRemote
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by ruitermatos on 14/03/18.
 */
interface Services {

    @GET("new.json")
    fun getPostsList(
            @Query("after") after: String?,
            @Query("limit") limit: String,
            @Query("raw_json") raw: String
    ) : Single<PostsListRemote>
}