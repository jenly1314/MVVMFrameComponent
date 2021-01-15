package com.king.mvvm.base.template

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import com.king.frame.mvvmframe.base.BaseModel
import com.king.mvvm.base.BaseViewModel

/**
 * ViewModel示例
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class TemplateViewModel @ViewModelInject constructor(application: Application, model: BaseModel) : BaseViewModel(application,model)