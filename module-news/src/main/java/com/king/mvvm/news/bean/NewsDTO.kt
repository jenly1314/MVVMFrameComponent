package com.king.mvvm.news.bean

import com.google.gson.annotations.SerializedName

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
data class NewsDTO(

    var title: String? = null,
    var date: String? = null,
    var category: String? = null,
    @SerializedName("author_name")
    var authorName: String? = null,
    var url: String? = null,
    @SerializedName("thumbnail_pic_s")
    var pic1: String? = null,
    @SerializedName("thumbnail_pic_s02")
    var pic2: String? = null,
    @SerializedName("thumbnail_pic_s03")
    var pic3: String? = null
)