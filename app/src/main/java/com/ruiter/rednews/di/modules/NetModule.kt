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
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.ruiter.rednews.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor

@Module
class NetModule {

    @Provides
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Provides
    fun provideOkhttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        val level = getInterceptorLevel()
        httpLoggingInterceptor.level = level

        val client = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
        return client.build()
    }

    private fun getInterceptorLevel(): HttpLoggingInterceptor.Level {
        return if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
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