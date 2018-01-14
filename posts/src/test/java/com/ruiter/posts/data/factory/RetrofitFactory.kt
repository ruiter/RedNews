package com.ruiter.posts.data.factory

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit



class RetrofitFactory {
    private lateinit var retrofit: Retrofit

    fun getRetrofit(): Retrofit {

        retrofit = Retrofit.Builder()
                .baseUrl("https://api.myjson.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit
    }
}