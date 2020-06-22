package com.king.mvvm.base.template

import android.app.Application
import com.king.frame.mvvmframe.base.BaseModel
import com.king.mvvm.base.BaseViewModel
import javax.inject.Inject

/**
 * ViewModel示例
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class TemplateViewModel @Inject constructor(application: Application, model: BaseModel) : BaseViewModel(application,model)