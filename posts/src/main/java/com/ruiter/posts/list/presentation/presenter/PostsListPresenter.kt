package com.ruiter.posts.list.presentation.presenter

import com.ruiter.posts.list.domain.interactor.GetPostsList
import com.ruiter.posts.list.domain.models.DataRequestResponse
import com.ruiter.posts.list.domain.models.PostsListBusinness
import com.ruiter.posts.list.presentation.mapper.toPostsList
import com.ruiter.posts.list.presentation.models.PostsList
import com.ruiter.posts.list.presentation.view.PostsListView
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class PostsListPresenter @Inject constructor(val view: PostsListView, val getPostsList: GetPostsList) : Presenter {
    var after: String? = null
    private lateinit var dataRequest: DataRequestResponse

    override fun destroy() {
        getPostsList.dispose()
    }

    fun request(bool: Boolean) {

        if (!bool) {
            view.hideError()
            view.showProgress()
            after = null
        }

        dataRequest = DataRequestResponse(after, "10")

        getPostsList.execute(PostsListSubscriber(), dataRequest)
    }

    inner class PostsListSubscriber: DisposableSingleObserver<PostsListBusinness>() {

        override fun onSuccess(t: PostsListBusinness) {
            val postsList: PostsList = t.toPostsList()

            after = postsList.dataResponse.after
            view.setAdapter(postsList)
            view.hideProgress()
        }

        override fun onError(exception: Throwable) {
            view.hideProgress()
            view.showError()
        }
    }
}