package com.king.mvvm.base.adapter

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.king.base.adapter.holder.ViewHolder


/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class BindViewHolder<VDB: ViewDataBinding>(view: View) : ViewHolder(view) {

    val dataBinding: VDB? = DataBindingUtil.bind<VDB>(convertView)
}