package com.ruiter.rednews.di.modules

import com.google.gson.Gson
import com.ruiter.rednews.constants.Constants.Companion.SERVICE_ENDPOINT
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import android.app.Application
import okhttp3.Cache
import javax.inject.Singleton
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder





@Module
class NetModule {

    @Provides
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Provides
    fun provideOkHttpCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10 MiB
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(SERVICE_ENDPOINT)
                .client(okHttpClient)
                .build()
    }
}