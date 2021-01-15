package com.king.mvvm.news.app.main

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.king.mvvm.base.BaseViewModel
import com.king.mvvm.news.app.Constants
import com.king.mvvm.news.bean.NewsDTO

/**
 * 标准 ViewModel层
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class NewsMainViewModel @ViewModelInject constructor(application: Application, val model: NewsMainModel) : BaseViewModel(application,model){

    val liveData by lazy { MutableLiveData<MutableList<NewsDTO>>() }

    /**
     * 获取新闻列表
     *
     * @param showLoading
     */
    fun getNewsList(showLoading: Boolean){
        launch(showLoading = showLoading) {
            val params = HashMap<String,Any>()
            params["type"] = "top"
            params["key"] = Constants.APP_KEY

            val response = model.getNewsList(params)

            if(isSuccess(response)){
                response.result?.data?.let {
                    liveData.value = it
                }
            }
        }
    }

    fun refresh(){
        getNewsList(false)
    }

}