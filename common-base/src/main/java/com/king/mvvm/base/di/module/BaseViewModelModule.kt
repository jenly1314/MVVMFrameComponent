package com.king.mvvm.base.di.module

import androidx.lifecycle.ViewModel
import com.king.frame.mvvmframe.di.scope.ViewModelKey
import com.king.mvvm.base.BaseViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@Module
abstract class BaseViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BaseViewModel::class)
    abstract fun bindBaseViewModel(viewModel: BaseViewModel) : ViewModel

}