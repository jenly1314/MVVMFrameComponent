package com.king.mvvm.news.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.king.mvvm.base.glide.ImageLoader
import com.king.mvvm.news.R

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */


@BindingAdapter(value = ["imageUrl"])
fun ImageView.imageUrl(imageUrl: String?){
    ImageLoader.displayImage(this,imageUrl, R.drawable.news_default_image)
}