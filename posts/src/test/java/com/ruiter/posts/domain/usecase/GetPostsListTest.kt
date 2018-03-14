package com.ruiter.posts.domain.usecase

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.ruiter.posts.list.domain.models.DataRequestList
import com.ruiter.posts.list.domain.repository.PostsListBusinnessRepository
import org.junit.Before
import org.junit.Test

/**
 * Created by ruitermatos on 13/03/18.
 */
class GetPostsListTest {

    private lateinit var params: DataRequestList
    private lateinit var postsListBusinnessRepository: PostsListBusinnessRepository
    private var after: String? = null
    private var limit = "10"

    @Before
    fun setUp() {

        postsListBusinnessRepository = mock()
        params = DataRequestList(after, limit)
    }

    @Test
    fun buildUseCasePostsCallsRepository() {
        postsListBusinnessRepository.getPostsList(params)
        verify(postsListBusinnessRepository).getPostsList(params)
    }
}