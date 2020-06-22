package com.king.mvvm.joke.di.component

import com.king.frame.mvvmframe.di.component.AppComponent
import com.king.mvvm.base.BaseApplicationInjector
import com.king.mvvm.base.di.scope.JokeScope
import com.king.mvvm.joke.di.module.JokeApplicationModule
import dagger.Component


/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@JokeScope
@Component(dependencies = [AppComponent::class], modules = [JokeApplicationModule::class])
interface JokeComponent : BaseApplicationInjector {

}