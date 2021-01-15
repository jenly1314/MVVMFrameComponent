package com.king.mvvm.component.app.splash

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import com.king.frame.mvvmframe.base.BaseModel
import com.king.mvvm.base.BaseViewModel

/**
 * 模板示例
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class AppSplashViewModel @ViewModelInject constructor(application: Application, model: BaseModel) : BaseViewModel(application,model)