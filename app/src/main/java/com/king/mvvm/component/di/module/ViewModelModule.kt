package com.king.mvvm.component.di.module

import androidx.lifecycle.ViewModel
import com.king.frame.mvvmframe.di.scope.ViewModelKey
import com.king.mvvm.component.app.splash.AppSplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AppSplashViewModel::class)
    abstract fun bindAppSplashViewModel(viewModel: AppSplashViewModel) : ViewModel

}