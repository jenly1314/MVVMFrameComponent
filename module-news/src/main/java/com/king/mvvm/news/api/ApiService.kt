package com.king.mvvm.news.api

import com.king.mvvm.base.bean.Response
import com.king.mvvm.news.bean.NewsDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@JvmSuppressWildcards
interface ApiService {


    @GET("toutiao/index")
    fun getNewsList(@QueryMap params: Map<String,Any>): Call<Response<MutableList<NewsDTO>>>
}