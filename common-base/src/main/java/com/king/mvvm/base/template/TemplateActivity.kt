package com.king.mvvm.base.template

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.king.mvvm.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * Activity模板示例
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@AndroidEntryPoint
class TemplateActivity : BaseActivity<TemplateViewModel,ViewDataBinding>(){

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int {
        //TODO layoutId
        return 0
    }

}