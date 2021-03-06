package com.ruiter.rednews.di.modules

import com.ruiter.network.Services
import com.ruiter.network.posts.PostsRemoteImpl
import com.ruiter.posts.list.data.repository.PostsListDataRepository
import com.ruiter.posts.list.data.repository.source.PostsListDataStore
import com.ruiter.posts.list.data.repository.source.PostsListDataStoreImpl
import com.ruiter.posts.list.domain.interactor.GetPostsList
import com.ruiter.posts.list.domain.models.DataRequestList
import com.ruiter.posts.list.domain.repository.PostsListBusinnessRepository
import com.ruiter.posts.list.presentation.presenter.PostsListPresenter
import com.ruiter.posts.list.presentation.presenter.Presenter
import com.ruiter.posts.list.presentation.view.PostsListActivity
import com.ruiter.posts.list.presentation.view.PostsListView
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RedNewsListModule {

    @Provides
    fun providePostsListDataStoreImpl(services: Services) : PostsListDataStore = PostsRemoteImpl(services)

    @Provides
    fun providePostsListView(postsListActivity: PostsListActivity) : PostsListView {
        return postsListActivity
    }

    @Provides
    fun providePostsListBusinnessRepository(postsListDataImpl: PostsListDataStoreImpl) : PostsListBusinnessRepository {
        return PostsListDataRepository(postsListDataImpl)
    }

    @Provides
    fun providePostsListPresenter(postsListView: PostsListView, getPostsList: GetPostsList, dataRequestList: DataRequestList) : Presenter {
        return PostsListPresenter(postsListView, getPostsList, dataRequestList)
    }

    @Provides
    fun providePostsListService(retrofit: Retrofit) : Services {
        return retrofit.create(Services::class.java)
    }

    @Provides
    fun provideDataRequestList() : DataRequestList {
        return DataRequestList(null, "10")
    }
}