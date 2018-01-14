package com.ruiter.rednews.di

import com.ruiter.posts.list.presentation.view.PostsListActivity
import com.ruiter.rednews.di.modules.RedNewsListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(RedNewsListModule::class)])
    internal abstract fun bindRedNewsListActivity() : PostsListActivity
}