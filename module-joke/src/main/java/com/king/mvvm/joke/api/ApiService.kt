package com.king.mvvm.joke.api

import com.king.mvvm.base.bean.Response
import com.king.mvvm.joke.bean.JokeDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@JvmSuppressWildcards
interface ApiService {

    /**
     * 获取笑话列表
     *
     * @return
     */
    @GET("joke/content/list.php")
    fun getJokeList(@QueryMap params: Map<String,Any>): Call<Response<MutableList<JokeDTO>>>

}