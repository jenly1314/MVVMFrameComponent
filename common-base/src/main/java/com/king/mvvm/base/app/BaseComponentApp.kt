package com.king.mvvm.base.app

import com.king.mvvm.base.BaseApp
import com.king.mvvm.base.IComponentApp
import com.king.mvvm.base.di.component.DaggerBaseComponent

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class BaseComponentApp : IComponentApp {

    override fun onCreate(app: BaseApp) {
        DaggerBaseComponent.builder()
            .appComponent(app.appComponent)
            .build()
            .inject(app)
    }


}