package com.ruiter.posts.data

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import com.ruiter.posts.list.data.mapper.toPostsListBusinness
import com.ruiter.posts.list.data.models.ChildrenResponse
import com.ruiter.posts.list.data.models.DataResponse
import com.ruiter.posts.list.data.models.PostsListResponse
import com.ruiter.posts.list.data.net.PostsListService
import com.ruiter.posts.list.data.repository.PostsListDataRepository
import com.ruiter.posts.list.data.repository.source.PostsListDataImpl
import com.ruiter.posts.list.domain.models.DataRequestList
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

    private var dataRequest = DataRequestList(after, limit)

    @Before
    fun setUp() {
        service = mock()
        listDataImpl = PostsListDataImpl(service)
        listDataRepository = PostsListDataRepository(listDataImpl)
    }

    @Test
    fun listAssertComplete() {
        listServiceGetSingle(Single.just(makeListResponse()))
        val observer = listDataImpl.getPostsList(after, limit).test()
        observer.assertComplete()
    }

    @Test
    fun assertValueListDataResponse() {
        val listResponse = makeListResponse()
        listServiceGetSingle(Single.just(listResponse))

        val listBusiness = listResponse.toPostsListBusinness()

        val observer = listDataRepository.getPostsList(dataRequest).test()
        observer.assertValue(listBusiness)
    }

    private fun listServiceGetSingle(single: Single<PostsListResponse>) {
        whenever(service.getPostsList(after, limit, raw))
                .thenReturn(single)
    }

    private fun makeListResponse() : PostsListResponse {
        return PostsListResponse("Listing", dataResponse)
    }
}