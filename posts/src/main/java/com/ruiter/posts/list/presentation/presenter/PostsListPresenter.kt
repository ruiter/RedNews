package com.ruiter.posts.list.presentation.presenter

import android.util.Log
import com.ruiter.posts.list.domain.interactor.GetPostsList
import com.ruiter.posts.list.domain.models.DataRequestResponse
import com.ruiter.posts.list.domain.models.PostsListBusinness
import com.ruiter.posts.list.presentation.mapper.toPostsList
import com.ruiter.posts.list.presentation.model.PostsList
import com.ruiter.posts.list.presentation.view.PostsListView
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class PostsListPresenter @Inject constructor(val view: PostsListView, val getPostsList: GetPostsList) : Presenter {
    override fun destroy() {
        Log.i("ruiter", "destroy presenter")
    }

    fun request() {
        val dataRequest = DataRequestResponse("", "10")

        getPostsList.execute(PostsListSubscriber(), dataRequest)
    }

    inner class PostsListSubscriber: DisposableSingleObserver<PostsListBusinness>() {

        override fun onSuccess(t: PostsListBusinness) {
            val postsList: PostsList = t.toPostsList()
            view.setAdapter(postsList)
            Log.i("ruiter", "onSucess " + postsList)
        }

        override fun onError(exception: Throwable) {
            Log.i("ruiter", "onError " + exception.message)
        }

    }
}