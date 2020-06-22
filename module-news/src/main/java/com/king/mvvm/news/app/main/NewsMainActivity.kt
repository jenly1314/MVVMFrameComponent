package com.king.mvvm.news.app.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.king.mvvm.base.BaseActivity
import com.king.mvvm.base.Constants
import com.king.mvvm.base.adapter.BaseAdapter
import com.king.mvvm.news.R
import com.king.mvvm.news.bean.NewsDTO
import com.king.mvvm.news.databinding.NewsActivityMainBinding
import kotlinx.android.synthetic.main.news_activity_main.*

@Route(path = Constants.ROUTE.NEWS_MAIN)
class NewsMainActivity : BaseActivity<NewsMainViewModel, NewsActivityMainBinding>(){

    private val mAdapter by lazy { BaseAdapter<NewsDTO>(context,R.layout.news_rv_news_item) }

    override fun initData(savedInstanceState: Bundle?) {
        viewModel.liveData.observe(this, Observer {
            mAdapter.listData = it
            mAdapter.notifyDataSetChanged()
        })
        supportActionBar?.setTitle(R.string.news_app_name)
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = mAdapter

        viewDataBinding.viewModel = viewModel

        viewModel.getNewsList(true)
    }

    override fun getLayoutId(): Int {
        //TODO layoutId
        return R.layout.news_activity_main
    }


    override fun hideLoading() {
        super.hideLoading()
        srl.isRefreshing = false
    }

}
