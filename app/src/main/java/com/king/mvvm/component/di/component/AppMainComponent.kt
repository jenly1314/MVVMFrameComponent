package com.king.mvvm.component.di.component

import com.king.frame.mvvmframe.di.component.AppComponent
import com.king.mvvm.base.BaseApplicationInjector
import com.king.mvvm.base.di.scope.AppScope
import com.king.mvvm.component.di.module.ApplicationModule
import dagger.Component

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@AppScope
@Component(dependencies = [AppComponent::class], modules = [ApplicationModule::class])
interface AppMainComponent : BaseApplicationInjector {

}