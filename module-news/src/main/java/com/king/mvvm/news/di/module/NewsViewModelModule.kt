package com.king.mvvm.news.di.module

import androidx.lifecycle.ViewModel
import com.king.frame.mvvmframe.di.scope.ViewModelKey
import com.king.mvvm.news.app.main.NewsMainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@Module
abstract class NewsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsMainViewModel::class)
    abstract fun bindNewsMainViewModel(viewModel: NewsMainViewModel) : ViewModel

}