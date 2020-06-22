package com.king.mvvm.base.glide

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
object ImageLoader {


    fun displayImage(iv: ImageView, url: String?, defaultImage: Int){
        url?.let {
            Glide.with(iv).load(url).placeholder(defaultImage).error(defaultImage).into(iv)
        } ?: run {
            iv.setImageResource(defaultImage)
        }
    }

    fun displayImage(context: Context, iv: ImageView, url: String?, defaultImage: Int){
        url?.let {
            Glide.with(context).load(url).placeholder(defaultImage).error(defaultImage).into(iv)
        } ?: run {
            iv.setImageResource(defaultImage)
        }
    }

    fun displayImage(fragment: Fragment, iv: ImageView, url: String?, defaultImage: Int){
        url?.let {
            Glide.with(fragment).load(url).placeholder(defaultImage).error(defaultImage).into(iv)
        } ?: run {
            iv.setImageResource(defaultImage)
        }
    }

    fun displayImage(activity: Activity, iv: ImageView, url: String?, defaultImage: Int){
        url?.let {
            Glide.with(activity).load(url).placeholder(defaultImage).error(defaultImage).into(iv)
        } ?: run {
            iv.setImageResource(defaultImage)
        }
    }

}