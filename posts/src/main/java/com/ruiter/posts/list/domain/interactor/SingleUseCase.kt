package com.ruiter.posts.list.domain.interactor

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<T, in Params> {
    private val disposables = CompositeDisposable()

    internal abstract fun buildUseCaseSingle(params: Params): Single<T>

    fun execute(singleObserver: DisposableSingleObserver<T>, params: Params) {
        val observable = this.buildUseCaseSingle(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        addDisposable(observable.subscribeWith(singleObserver))
    }

    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}