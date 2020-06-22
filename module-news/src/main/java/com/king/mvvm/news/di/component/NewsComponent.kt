package com.king.mvvm.news.di.component

import com.king.frame.mvvmframe.di.component.AppComponent
import com.king.mvvm.base.BaseApplicationInjector
import com.king.mvvm.base.di.scope.NewsScope
import com.king.mvvm.news.di.module.NewsApplicationModule
import dagger.Component


/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@NewsScope
@Component(dependencies = [AppComponent::class], modules = [NewsApplicationModule::class])
interface NewsComponent : BaseApplicationInjector {

}