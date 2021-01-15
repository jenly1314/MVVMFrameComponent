package com.king.mvvm.base.config

import android.content.Context
import com.king.frame.mvvmframe.config.FrameConfigModule
import com.king.frame.mvvmframe.di.module.ConfigModule
import com.king.mvvm.base.Constants

/**
 * 自定义全局配置
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class AppConfigModule : FrameConfigModule() {

    override fun applyOptions(context: Context, builder: ConfigModule.Builder) {
        builder.baseUrl(Constants.BASE_URL)
    }
}