package com.king.mvvm.base

import androidx.databinding.ViewDataBinding

import com.king.frame.mvvmframe.base.BaseActivity
import com.king.frame.mvvmframe.base.BaseModel
import com.king.frame.mvvmframe.base.BaseViewModel

/**
 * 这里写一层 BaseActivity 是为了方便统一维护公共的一些配置，只是一个示例，如果您没有
 * 此需求可以忽略这一层，直接继承 [com.king.frame.mvvmframe.base.BaseActivity]即可
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
abstract class BaseActivity<VM : BaseViewModel<out BaseModel>,VDB : ViewDataBinding> : BaseActivity<VM,VDB>(){

}