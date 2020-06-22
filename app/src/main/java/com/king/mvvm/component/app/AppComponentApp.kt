package com.king.mvvm.component.app

import com.king.mvvm.base.BaseApp
import com.king.mvvm.base.IComponentApp
import com.king.mvvm.component.di.component.DaggerAppMainComponent

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class AppComponentApp: IComponentApp {

    override fun onCreate(app: BaseApp) {
        DaggerAppMainComponent.builder()
            .appComponent(app.appComponent)
            .build()
            .inject(app)

    }

}