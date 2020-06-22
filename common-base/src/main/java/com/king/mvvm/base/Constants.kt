package com.king.mvvm.base

import com.king.frame.mvvmframe.di.module.ViewModelFactoryModule

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
object Constants {

    const val BASE_URL = "http://v.juhe.cn"

    const val TAG = "Jenly"

    val t = ViewModelFactoryModule::class

    /**
     * Route paths
     */
    object ROUTE{

        const val JOKE_MAIN = "/joke/main"
        const val NEWS_MAIN = "/news/main"

    }

}