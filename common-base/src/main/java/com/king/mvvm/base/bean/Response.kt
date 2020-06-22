package com.king.mvvm.base.bean

import com.google.gson.annotations.SerializedName

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class Response<T> {

    @SerializedName("error_code")
    var code: Int? = 0

    var reason: String? = null

    var result: Result<T>? = null

    fun isSuccess() = code == 0
}