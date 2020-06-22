package com.king.mvvm.base

/**
 * 用于模块/组件的各个 Module 在 Application 中初始化一些配置
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
interface IComponentApp {
    /**
     * 用于模块/组件的初始化
     *
     * @param app
     */
    fun onCreate(app: BaseApp)


    fun onTerminate(){

    }

}