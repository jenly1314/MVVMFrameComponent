package com.king.mvvm.joke.di.module

import androidx.lifecycle.ViewModel
import com.king.frame.mvvmframe.di.scope.ViewModelKey
import com.king.mvvm.joke.app.main.JokeMainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@Module
abstract class JokeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(JokeMainViewModel::class)
    abstract fun bindJokeMainViewModel(viewModel: JokeMainViewModel) : ViewModel

}