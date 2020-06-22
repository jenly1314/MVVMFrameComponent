package com.king.mvvm.component.app.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.app.ActivityOptionsCompat
import com.king.mvvm.base.BaseActivity
import com.king.mvvm.component.R
import com.king.mvvm.component.app.main.AppMainActivity
import com.king.mvvm.component.databinding.AppActivitySplashBinding
import kotlinx.android.synthetic.main.app_activity_splash.*

/**
 * 模板示例
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class AppSplashActivity : BaseActivity<AppSplashViewModel,AppActivitySplashBinding>(){

    override fun initData(savedInstanceState: Bundle?) {
        startAnimation(rootView)
    }

    override fun getLayoutId(): Int {
        //TODO layoutId
        return R.layout.app_activity_splash
    }

    private fun startAnimation(view: View) {
        val anim = AnimationUtils.loadAnimation(context, R.anim.app_splash_anim)
        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationEnd(animation: Animation) {
                startMainActivity()
            }

            override fun onAnimationRepeat(animation: Animation) {

            }
        })
        view.startAnimation(anim)
    }

    private fun startMainActivity(){
        val intent = Intent(context, AppMainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val optionsCompat = ActivityOptionsCompat.makeCustomAnimation(context, R.anim.alpha_in_anim, R.anim.alpha_out_anim)
        startActivity(intent, optionsCompat.toBundle())

    }

}