package com.king.mvvm.base.adapter

import android.content.Context
import com.king.base.adapter.BaseRecyclerAdapter
import com.king.mvvm.base.BR

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
open class BaseAdapter<T>(context: Context,layoutId: Int,private val variableId: Int = BR.data) : BaseRecyclerAdapter<T,BindViewHolder<*>>(context,layoutId) {

    override fun bindViewDatas(holder: BindViewHolder<*>, item: T, position: Int) {
        holder.dataBinding?.let {
            it.setVariable(variableId,item)
            it.executePendingBindings()
        }
    }
}