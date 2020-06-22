package com.king.mvvm.news.di.module

import com.king.frame.mvvmframe.di.component.BaseActivitySubcomponent
import com.king.mvvm.news.app.main.NewsMainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@Module(subcomponents = [BaseActivitySubcomponent::class])
abstract class NewsActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeNewsMainActivity(): NewsMainActivity
}