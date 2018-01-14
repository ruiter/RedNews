package com.ruiter.posts.list.domain.interactor

import com.ruiter.posts.list.domain.models.DataRequestResponse
import com.ruiter.posts.list.domain.models.PostsListBusinness
import com.ruiter.posts.list.domain.repository.PostsListBusinnessRepository
import io.reactivex.Single

class GetPostsList constructor(private val postsListBusinnessRepository: PostsListBusinnessRepository)
    : UseCase<PostsListBusinness, DataRequestResponse>() {

    override fun buildUseCaseSingle(params: DataRequestResponse): Single<PostsListBusinness> {
        return postsListBusinnessRepository.getPostsList(params)
    }
}