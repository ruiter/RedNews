package com.ruiter.posts.data

import com.nhaarman.mockito_kotlin.mock
import com.ruiter.posts.data.factory.PostsListFactory
import com.ruiter.posts.list.data.mapper.toPostsListBusinness
import com.ruiter.posts.list.data.models.ChildrenResponse
import com.ruiter.posts.list.data.models.DataResponse
import com.ruiter.posts.list.data.repository.PostsListDataRepository
import com.ruiter.posts.list.data.repository.source.PostsListDataStoreImpl
import com.ruiter.posts.list.domain.models.DataRequestList
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

/**
 * Created by ruitermatos on 13/03/18.
 */
class CheckReturnObjectDataResponseTest {

    private lateinit var service: PostsListService
    private lateinit var listDataImpl: PostsListDataStoreImpl
    private lateinit var listDataRepository: PostsListDataRepository
    private var after: String? = null
    private var limit = "10"
    private var raw = "1"
    private val listChildrenResponse = mutableListOf<ChildrenResponse>()

    private var dataResponse = DataResponse("all_ads", listChildrenResponse,
            after)

    private var dataRequest = DataRequestList(after, limit)

    @Before
    fun setUp() {
        service = mock()
        listDataImpl = PostsListDataStoreImpl(service)
        listDataRepository = PostsListDataRepository(listDataImpl)
    }

    @Test
    fun assertValueListDataResponse() {
        val listResponse = PostsListFactory.makeListResponse(dataResponse)
        PostsListFactory.listServiceGetSingle(Single.just(listResponse), service, after, limit, raw)

        val listBusiness = listResponse.toPostsListBusinness()

        val observer = listDataRepository.getPostsList(dataRequest).test()
        observer.assertValue(listBusiness)
    }
}