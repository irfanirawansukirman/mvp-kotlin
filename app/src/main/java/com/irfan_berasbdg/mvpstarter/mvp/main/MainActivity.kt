package com.irfan_berasbdg.mvpstarter.mvp.main

import android.os.Bundle
import com.irfan_berasbdg.mvpstarter.R
import com.irfan_berasbdg.mvpstarter.base.BaseActivity
import com.irfan_berasbdg.mvpstarter.util.Injection
import com.irfan_berasbdg.mvpstarter.util.replaceFragmentInActivity

class MainActivity : BaseActivity() {

    override fun getToolbarId(): Int = 0

    override fun getLayoutRes(): Int = R.layout.main_activity

    override fun onActivityStarted(savedInstanceState: Bundle?) {
        val moviesFragment = supportFragmentManager.findFragmentById(R.id.frm_main_container)
                as MainFragment? ?: MainFragment.newInstance().also {
            replaceFragmentInActivity(it, R.id.frm_main_container)
        }

        MainPresenter(Injection.provideMoviesRepository(this), moviesFragment)
    }
}
