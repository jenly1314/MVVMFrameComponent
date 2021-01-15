package com.king.mvvm.component.app.main

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.alibaba.android.arouter.launcher.ARouter
import com.king.base.util.ToastUtils
import com.king.mvvm.base.BaseActivity
import com.king.mvvm.base.BaseViewModel
import com.king.mvvm.base.Constants
import com.king.mvvm.component.BuildConfig
import com.king.mvvm.component.R
import dagger.hilt.android.AndroidEntryPoint

/**
 *
 * ## 工程 Module 说明
 *
 * ### app
 * 宿主App：当各个子 **Module** 作为 **library** 时，则可将所有组件集成到 **宿主App** 中。此时 **宿主App** 则是一个拥有所有组件功能集合的完整的App。
 *
 * ### common-base
 * 组件化公共基础库：主要包含 **MVVMFrame** 快速开发框架，和作为组件化的一些公共的核心基础库，方便快速构建组件化 **Project**。
 *
 * ### common-res
 * 组件化公共资源库：主要方便统一管理各个 **Module** 中的一些公共资源相关。
 *
 * ### module-joke
 * 一个简单的笑话功能模块：主要用来展示基于 **MVVMFrame** 来实现组件化开发，作为组件化开发的 **Module** 实现示例之一。
 *
 * ### module-news
 * 一个简单的新闻功能模块：主要用来展示基于 **MVVMFrame** 来实现组件化开发，作为组件化开发的 **Module** 实现示例之一。
 *
 */
@AndroidEntryPoint
class AppMainActivity : BaseActivity<BaseViewModel, ViewDataBinding>() {

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int {
        return R.layout.app_activity_main
    }

    override fun isBinding(): Boolean {
        return false
    }

    fun onClick(v: View){
        if(BuildConfig.isBuildModule){
            ToastUtils.showToast(context, R.string.app_toast_is_build_module)
            return
        }
        when(v.id){
            R.id.btnJoke -> ARouter.getInstance().build(Constants.ROUTE.JOKE_MAIN).navigation(this)
            R.id.btnNews -> ARouter.getInstance().build(Constants.ROUTE.NEWS_MAIN).navigation(this)
        }
    }


}