package com.king.mvvm.base

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.king.base.util.SystemUtils
import com.king.frame.mvvmframe.base.BaseModel
import com.king.frame.mvvmframe.base.DataViewModel
import com.king.mvvm.base.bean.Response
import kotlinx.coroutines.launch
import timber.log.Timber
import java.net.ConnectException
import java.net.SocketTimeoutException

/**
 * 这里写一层 BaseViewModel 是为了方便统一维护公共的一些配置，只是一个示例，如果您没有
 * 此需求可以忽略这一层，直接继承 [com.king.frame.mvvmframe.base.BaseViewModel]即可
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
open class BaseViewModel @ViewModelInject constructor(application: Application, model: BaseModel) : DataViewModel(application,model) {

    val liveDataTag by lazy { MutableLiveData<Int>() }

    open fun getBaseApp() = getApplication<BaseApp>()


    fun isSuccess(response: Response<*>?) = response?.let {
        val isSuccess = it.isSuccess()
        if(!isSuccess){
            sendMessage(it.reason)
        }
        isSuccess
    } ?: kotlin.run {
        sendMessage(R.string.res_response_failure)
        false
    }

    fun launch(tag: Int? = null,showLoading: Boolean = true,block: suspend () -> Unit){
        launch(tag,showLoading,block,{
            Timber.w(it)
            if(SystemUtils.isNetWorkActive(getBaseApp())){
                when(it){
                    is SocketTimeoutException -> sendMessage(R.string.res_response_connect_timeout_error)
                    is ConnectException -> sendMessage(R.string.res_response_connect_failed_error)
                    else -> sendMessage(R.string.res_response_error)
                }
            }else{
                sendMessage(R.string.res_response_network_unavailable_error)
            }
        })
    }

    private fun launch(tag: Int?,showLoading: Boolean, block: suspend () -> Unit, error: suspend (Throwable) -> Unit) = viewModelScope.launch {
        try {
            if(showLoading){
                showLoading()
            }
            block()
        }catch (e: Throwable){
            error(e)
        }

        hideLoading()

        tag?.let {
            liveDataTag.value = it
        }

    }

}