package id.gits.gitsmvpkotlingooglebase.mvp.main

import android.os.Bundle
import android.view.View
import id.gits.gitsmvpkotlingooglebase.base.BaseFragment
import id.gits.gitsmvpkotlingooglebase.data.model.Movie

import id.gits.gitsmvpkotlingooglebase.R
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