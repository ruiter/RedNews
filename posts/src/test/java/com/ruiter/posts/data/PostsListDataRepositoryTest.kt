package com.ruiter.posts.data

import com.nhaarman.mockito_kotlin.mock
import com.ruiter.posts.list.data.net.PostsListService
import com.ruiter.posts.list.data.repository.PostsListDataRepository
import com.ruiter.posts.list.data.repository.source.PostsListDataImpl
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test

class PostsListDataRepositoryTest {

    val postsListService = mock<PostsListService>()

    lateinit var postsListDataRepository: PostsListDataRepository
    lateinit var postsListDataImpl: PostsListDataImpl

    @Before
    fun setUp() {
        postsListDataImpl = PostsListDataImpl(postsListService)
        postsListDataRepository = PostsListDataRepository(postsListDataImpl)
    }

    @Test
    fun getListPostsTest() {
        System.out.print("single " + postsListDataRepository.getPostsList(null, "10"))

        val disposable = postsListDataRepository.getPostsList(null, "10")
                .subscribeOn(Schedulers.trampoline())
                .observeOn(Schedulers.trampoline())
                .subscribe({
                    System.out.println("data: " + it)
                },{
                    System.out.println("error: " + it.message)
                })
    }
}