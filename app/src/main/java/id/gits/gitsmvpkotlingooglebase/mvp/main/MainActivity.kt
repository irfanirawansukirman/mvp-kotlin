package id.gits.gitsmvpkotlingooglebase.mvp.main

import android.os.Bundle
import id.gits.gitsmvpkotlingooglebase.R
import id.gits.gitsmvpkotlingooglebase.base.BaseActivity
import id.gits.gitsmvpkotlingooglebase.util.Injection
import id.gits.gitsmvpkotlingooglebase.util.replaceFragmentInActivity

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
