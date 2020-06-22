package com.king.mvvm.joke.di.module

import com.king.frame.mvvmframe.di.component.BaseActivitySubcomponent
import com.king.mvvm.joke.app.main.JokeMainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@Module(subcomponents = [BaseActivitySubcomponent::class])
abstract class JokeActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeJokeMainActivity(): JokeMainActivity
}