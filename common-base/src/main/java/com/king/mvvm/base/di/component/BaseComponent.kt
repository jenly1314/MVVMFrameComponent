package com.king.mvvm.base.di.component

import com.king.frame.mvvmframe.di.component.AppComponent
import com.king.frame.mvvmframe.di.module.ViewModelFactoryModule
import com.king.mvvm.base.BaseApplicationInjector
import com.king.mvvm.base.di.module.BaseViewModelModule
import com.king.mvvm.base.di.scope.BaseScope
import dagger.Component

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@BaseScope
@Component(dependencies = [AppComponent::class], modules = [ViewModelFactoryModule::class,BaseViewModelModule::class])
interface BaseComponent : BaseApplicationInjector {

}