package com.ruiter.posts.list.presentation.presenter

import android.util.Log
import com.ruiter.posts.list.domain.interactor.GetPostsList
import com.ruiter.posts.list.domain.models.DataRequestList
import com.ruiter.posts.list.domain.models.PostsListBusinness
import com.ruiter.posts.list.presentation.mapper.toPostsList
import com.ruiter.posts.list.presentation.models.PostsList
import com.ruiter.posts.list.presentation.view.PostsListView
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class PostsListPresenter @Inject constructor(val view: PostsListView,
                                             private val getPostsList: GetPostsList,
                                             private var dataRequest: DataRequestList) : Presenter {

    override fun destroy() {
        getPostsList.dispose()
    }

    override fun request(bool: Boolean) {

        if (!bool) {
            view.hideError()
            view.showProgress()
            dataRequest.after = null
        }

        getPostsList.execute(PostsListSubscriber(), dataRequest)
    }

    inner class PostsListSubscriber: DisposableSingleObserver<PostsListBusinness>() {

        override fun onSuccess(result: PostsListBusinness) {
            Log.i("ruiter", "result : " + result);
            val postsList: PostsList = result.toPostsList()

            dataRequest.after = postsList.dataResponse.after
            view.setAdapter(postsList)
            view.hideProgress()
        }

        override fun onError(exception: Throwable) {
            Log.i("ruiter", "exception : " + exception.localizedMessage);

            view.hideProgress()
            view.showError()
        }
    }
}