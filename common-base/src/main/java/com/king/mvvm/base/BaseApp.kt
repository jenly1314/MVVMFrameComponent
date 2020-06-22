package com.king.mvvm.base

import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.king.frame.mvvmframe.base.BaseApplication
import com.king.mvvm.base.app.BaseComponentApp
import com.king.mvvm.base.parser.AppManifestParser
import com.king.retrofit.retrofithelper.RetrofitHelper
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import timber.log.Timber

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
open class BaseApp : BaseApplication(){

    var isShowLog = true

    var componentApps: MutableList<IComponentApp>? = null

    override fun attachBaseContext(base: Context) {
        //初始化打印日志
        var formatStrategy = PrettyFormatStrategy.newBuilder()
            .methodOffset(5)
            .tag(Constants.TAG)
            .build()

        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))

        Timber.plant(object : Timber.DebugTree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                if (isShowLog) {
                    Logger.log(priority, tag, message, t)
                }
            }
        })

        super.attachBaseContext(base)

    }

    override fun onCreate() {
        RetrofitHelper.getInstance().setBaseUrl(Constants.BASE_URL)
        super.onCreate()

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
     * 初始化各个子 module
     */
    private fun initComponentApp(){
        BaseComponentApp().onCreate(this)
        this.componentApps = AppManifestParser(this).parse()
        componentApps?.let {
            for(app in it){
                app.onCreate(this)
                Timber.d("componnentApp:${app::class.java}")
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


}