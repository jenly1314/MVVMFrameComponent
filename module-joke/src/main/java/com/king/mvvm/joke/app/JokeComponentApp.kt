package com.king.mvvm.joke.app

import com.king.mvvm.base.BaseApp
import com.king.mvvm.base.IComponentApp
import com.king.mvvm.joke.di.component.DaggerJokeComponent

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class JokeComponentApp : IComponentApp{

    override fun onCreate(app: BaseApp) {
        DaggerJokeComponent.builder()
            .appComponent(app.appComponent)
            .build()
            .inject(app)
    }

}