package com.king.mvvm.component.di.module

import com.king.frame.mvvmframe.di.component.BaseActivitySubcomponent
import com.king.mvvm.component.app.main.AppMainActivity
import com.king.mvvm.component.app.splash.AppSplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@Module(subcomponents = [BaseActivitySubcomponent::class])
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeAppSplashActivity(): AppSplashActivity

    @ContributesAndroidInjector
    abstract fun contributeAppMainActivity(): AppMainActivity
}