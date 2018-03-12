package id.gits.gitsmvpkotlingooglebase.mvp.main

import id.gits.gitsmvpkotlingooglebase.base.BasePresenter
import id.gits.gitsmvpkotlingooglebase.base.BaseView
import id.gits.gitsmvpkotlingooglebase.data.model.Movie

/**
 * Created by irfanirawansukirman on 12/03/18.
 */
interface MainContract {
    interface View : BaseView<Presenter> {
        fun showProgress()
        fun hideProgress()
        fun showMovies(movies: List<Movie>)
        fun onFailed(errorMessage: String)
    }

    interface Presenter : BasePresenter {
        fun loadMovies()
        fun clearDisposable()
        fun openMovieDetail(movie: Movie)
    }
}