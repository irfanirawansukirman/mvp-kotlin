package com.irfan_berasbdg.mvpstarter.mvp.main

import android.os.Bundle
import android.view.View
import com.irfan_berasbdg.mvpstarter.R
import com.irfan_berasbdg.mvpstarter.base.BaseFragment
import com.irfan_berasbdg.mvpstarter.data.model.Movie
import kotlinx.android.synthetic.main.main_fragment.*

/**
 * Created by irfanirawansukirman on 12/03/18.
 */
class MainFragment: BaseFragment(), MainContract.View {

    override fun getLayoutRes(): Int = R.layout.main_fragment

    override fun onViewReady(view: View?, savedInstanceState: Bundle?) {

    }

    override fun showProgress() {
        showProgressDialog("", "Lorem Ipsum", false)
    }

    override fun hideProgress() {
        hideProgressDialog()
    }

    override fun showMovies(movies: List<Movie>) {
        txt_main_sample.text = movies[0].title
    }

    override fun onFailed(errorMessage: String) {
        showToast(errorMessage)
    }

    override fun onStart() {
        super.onStart()
        presenter.start()
    }

    override fun onDestroyView() {
        presenter.clearDisposable()
        super.onDestroyView()
    }

    override lateinit var presenter: MainContract.Presenter

    companion object {
        fun newInstance() = MainFragment()
    }
}