package com.king.mvvm.news.app

import com.king.mvvm.base.BaseApp
import com.king.mvvm.base.IComponentApp
import com.king.mvvm.news.di.component.DaggerNewsComponent

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class NewsComponentApp : IComponentApp{

    override fun onCreate(app: BaseApp) {
        DaggerNewsComponent.builder()
            .appComponent(app.appComponent)
            .build()
            .inject(app)
    }

}