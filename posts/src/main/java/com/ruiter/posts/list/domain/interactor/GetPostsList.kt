package com.ruiter.posts.list.domain.interactor

import com.ruiter.posts.list.domain.models.DataRequestList
import com.ruiter.posts.list.domain.models.PostsListBusinness
import com.ruiter.posts.list.domain.repository.PostsListBusinnessRepository
import io.reactivex.Single
import javax.inject.Inject

class GetPostsList @Inject constructor(private val postsListBusinnessRepository: PostsListBusinnessRepository)
    : SingleUseCase<PostsListBusinness, DataRequestList>() {

    override fun buildUseCaseSingle(params: DataRequestList): Single<PostsListBusinness> {
        return postsListBusinnessRepository.getPostsList(params)
    }
}