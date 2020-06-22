package com.king.mvvm.joke.bean

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
data class JokeDTO (

    var content: String? = null,

    var hashId: String? = null,

    var unixtime: Int? = null,

    var updatetime: String? = null

)