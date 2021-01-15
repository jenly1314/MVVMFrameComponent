package com.king.mvvm.news

import com.king.mvvm.base.BaseApp
import com.king.mvvm.base.IComponentApp
import dagger.hilt.android.HiltAndroidApp

/**
 * 这里是作为独立模块时使用，里面不包含任何逻辑，仅仅是为了符合Hilt规范。
 * 对于模块公用的可以尽量写在 [BaseApp] 中，对于模块相对独立使用的，可以写在模块对应 [IComponentApp] 的实现实现类中
 * 当前模块 [IComponentApp] 的实现类是 [NewsComponentApp]
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@HiltAndroidApp
class NewsApp : BaseApp()