package com.ruiter.rednews.di.modules

import com.ruiter.posts.list.data.net.PostsListService
import com.ruiter.posts.list.presentation.presenter.PostsListPresenter
import com.ruiter.posts.list.presentation.view.PostsListActivity
import com.ruiter.posts.list.presentation.view.PostsListView
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RedNewsListModule {

    @Provides
    fun providePostsListView(postsListActivity: PostsListActivity) : PostsListView {
        return postsListActivity
    }

    @Provides
    fun providePostsListPresenter(postsListView: PostsListView) : PostsListPresenter {
        return PostsListPresenter(postsListView)
    }

    @Provides
    fun providePostsListService(retrofit: Retrofit) : PostsListService {
        return retrofit.create(PostsListService::class.java)
    }
}