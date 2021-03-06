package com.ruiter.posts.list.data.repository

import android.util.Log
import com.ruiter.posts.list.data.mapper.toPostsListBusinness
import com.ruiter.posts.list.data.repository.source.PostsListDataStoreImpl
import com.ruiter.posts.list.domain.models.DataRequestList
import com.ruiter.posts.list.domain.models.PostsListBusinness
import com.ruiter.posts.list.domain.repository.PostsListBusinnessRepository
import io.reactivex.Single
import javax.inject.Inject

class PostsListDataRepository @Inject constructor(private val postsListDataImpl: PostsListDataStoreImpl)
    : PostsListBusinnessRepository {

    override fun getPostsList(dataParentBusinness: DataRequestList): Single<PostsListBusinness> {
        return postsListDataImpl.getPostsList(dataParentBusinness.after, dataParentBusinness.limit)
                .map {
                    Log.i("ruiter", "postlisresponse: " + it);
                    it.toPostsListBusinness()
                }
    }
}