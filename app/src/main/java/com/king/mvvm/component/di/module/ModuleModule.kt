package com.king.mvvm.component.di.module

import dagger.Module

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@Module(



    /**
     * TODO 根据根目录的 build.gradle 中的 rootProject.ext.isBuildModule 的值来决定是否需要屏蔽下面的 /*Module*/ 所在行
     *
     * <p>
     *     当 rootProject.ext.isBuildModule = true 时，如果 /*Module*/ 行未屏蔽，请屏蔽掉下面的 /*Module*/ 所在行。
     *     此时各个 module 作为 application 独立运行。
     * <p>
     *     当 rootProject.ext.isBuildModule = false 时，如果 /*Module*/ 行已屏蔽，请取消屏蔽下面的 /*Module*/ 所在行。
     *     此时各个 module 作为 library 合并到 宿主App。
     *
     * 只有当需要 build 宿主App 时，才需要用到下面的 /*Module*/ 所在行
     */
    //=== 如果需要屏蔽，请注释掉下面一行，如果不需要屏蔽请取消注释下面一行 ===//
    /*Module*/ includes = [com.king.mvvm.joke.di.module.JokeApplicationModule::class, com.king.mvvm.news.di.module.NewsApplicationModule::class] /*Module*/
    //=== 如果需要屏蔽，请注释掉上面一行，如果不需要屏蔽请取消注释上面一行 ===//



)
class ModuleModule {

}