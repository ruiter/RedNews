package com.ruiter.posts.data

import com.nhaarman.mockito_kotlin.mock
import com.ruiter.posts.data.factory.PostsListFactory.Factory.listServiceGetSingle
import com.ruiter.posts.data.factory.PostsListFactory.Factory.makeListResponse
import com.ruiter.posts.list.data.models.ChildrenResponse
import com.ruiter.posts.list.data.models.DataResponse
import com.ruiter.posts.list.data.net.PostsListService
import com.ruiter.posts.list.data.repository.PostsListDataRepository
import com.ruiter.posts.list.data.repository.source.PostsListDataImpl
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class ListDataServiceAndRepositoryTest {

    private lateinit var service: PostsListService
    private lateinit var listDataImpl: PostsListDataImpl
    private lateinit var listDataRepository: PostsListDataRepository
    private val listChildrenResponse = mutableListOf<ChildrenResponse>()
    private var after: String? = null
    private var limit = "10"
    private var raw = "1"

    private var dataResponse = DataResponse("all_ads", listChildrenResponse,
            after)

    @Before
    fun setUp() {
        service = mock()
        listDataImpl = PostsListDataImpl(service)
        listDataRepository = PostsListDataRepository(listDataImpl)
    }

    @Test
    fun checkReturnGetPostsList() {
        listServiceGetSingle(Single.just(makeListResponse(dataResponse)), service, after, limit, raw)

        val observer = listDataImpl.getPostsList(after, limit).test()

        observer.assertComplete()
    }
}