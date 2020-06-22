package com.king.mvvm.news.app.main

import com.king.frame.mvvmframe.base.BaseModel
import com.king.frame.mvvmframe.data.IDataRepository
import com.king.mvvm.news.api.ApiService
import retrofit2.await
import javax.inject.Inject

/**
 * 标准 Model层
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class NewsMainModel @Inject constructor(dataRepository: IDataRepository) : BaseModel(dataRepository) {

    private val apiService by lazy { getRetrofitService(ApiService::class.java) }

    /**
     * 获取新闻列表
     *
     * @param params
     */
    suspend fun getNewsList(params: Map<String,Any>) = apiService.getNewsList(params).await()
}