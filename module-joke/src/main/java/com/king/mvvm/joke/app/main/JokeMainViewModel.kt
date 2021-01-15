package com.king.mvvm.joke.app.main

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.king.frame.mvvmframe.base.BaseModel
import com.king.mvvm.base.BaseViewModel
import com.king.mvvm.joke.api.ApiService
import com.king.mvvm.joke.app.Constants
import com.king.mvvm.joke.bean.JokeDTO
import retrofit2.await

/**
 * ViewModel层，弱化 Model层
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class JokeMainViewModel @ViewModelInject constructor(application: Application, model: BaseModel) : BaseViewModel(application,model){

    private val apiService by lazy { getRetrofitService(ApiService::class.java) }

    val liveData by lazy { MutableLiveData<MutableList<JokeDTO>>() }

    /**
     * 获取笑话列表
     *
     * @param showLoading
     */
    fun getJokeList(showLoading: Boolean){
        launch(showLoading = showLoading) {
            val params = HashMap<String,Any>()
            params["sort"] = "dsc"
            params["time"] = System.currentTimeMillis().div(1000)
            params["key"] = Constants.APP_KEY

            val response = apiService.getJokeList(params).await()

            if(isSuccess(response)){
                response.result?.data?.let {
                    liveData.value = it
                }
            }
        }
    }

    fun refresh(){
        getJokeList(false)
    }

}