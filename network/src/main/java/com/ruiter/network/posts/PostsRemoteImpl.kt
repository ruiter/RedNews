package com.ruiter.network.posts

import android.util.Log
import com.ruiter.network.Services
import com.ruiter.network.posts.mapper.toPostsListResponse
import com.ruiter.posts.list.data.models.PostsListResponse
import com.ruiter.posts.list.data.repository.source.PostsListDataStore
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by ruitermatos on 26/03/18.
 */
class PostsRemoteImpl @Inject constructor(private val services: Services) : PostsListDataStore {

    override fun getPostsList(after: String?, limit: String): Single<PostsListResponse> {
        return services.getPostsList(after, limit, "1")
            .map {
                Log.i("ruiter", "PostsRemoteImpl: " + it);
                it.toPostsListResponse()
            }
    }
}