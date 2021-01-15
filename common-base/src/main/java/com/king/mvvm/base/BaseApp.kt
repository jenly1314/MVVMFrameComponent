package com.king.mvvm.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.king.mvvm.base.parser.AppManifestParser
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import timber.log.Timber

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
open class BaseApp : Application(){

    var componentApps: MutableList<IComponentApp>? = null

    override fun onCreate() {
        super.onCreate()
        initLogger()
        initComponentApp()
        initARouter()
    }

    override fun onTerminate() {
        super.onTerminate()
        componentApps?.let {
            for(app in it){
                app.onTerminate()
            }
        }
    }

    /**
     * 初始化打印日志
     */
    private fun initLogger(){
        var formatStrategy = PrettyFormatStrategy.newBuilder()
            .methodOffset(5)
            .tag(Constants.TAG)
            .build()

        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))

        Timber.plant(object : Timber.DebugTree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                if (BuildConfig.DEBUG) {
                    Logger.log(priority, tag, message, t)
                }
            }
        })
    }

    /**
     * 初始化各个子 module
     */
    private fun initComponentApp(){
        this.componentApps = AppManifestParser(this).parse()
        componentApps?.let {
            for(app in it){
                app.onCreate(this)
                Timber.d("ComponentApp:${app::class.java}")
            }
        }
    }

    private fun initARouter(){
        Timber.d("isDebug:${BuildConfig.DEBUG}")
        if(BuildConfig.DEBUG){
            ARouter.openLog()
            ARouter.openDebug()
        }

        ARouter.init(this)
    }

//    fun getComponentApp(cls: Class<Any>): IComponentApp{
//        componentApps?.forEach {
//            if(it is cls){
//
//            }
//        }
//    }

}