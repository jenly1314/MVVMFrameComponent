package com.king.mvvm.joke.app.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.king.mvvm.base.BaseActivity
import com.king.mvvm.base.Constants
import com.king.mvvm.base.adapter.BaseAdapter
import com.king.mvvm.joke.R
import com.king.mvvm.joke.bean.JokeDTO
import com.king.mvvm.joke.databinding.JokeActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.joke_activity_main.*

@Route(path = Constants.ROUTE.JOKE_MAIN)
@AndroidEntryPoint
class JokeMainActivity : BaseActivity<JokeMainViewModel, JokeActivityMainBinding>(){

    private val mAdapter by lazy { BaseAdapter<JokeDTO>(context,R.layout.joke_rv_joke_item) }

    override fun initData(savedInstanceState: Bundle?) {
        viewModel.liveData.observe(this, Observer {
            mAdapter.listData = it
            mAdapter.notifyDataSetChanged()
        })

        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = mAdapter

        viewDataBinding.viewModel = viewModel

        viewModel.getJokeList(true)

    }

    override fun getLayoutId(): Int {
        //TODO layoutId
        return R.layout.joke_activity_main
    }


    override fun hideLoading() {
        super.hideLoading()
        srl.isRefreshing = false
    }

}
