package com.irfan_berasbdg.mvpstarter.mvp.main

import com.irfan_berasbdg.mvpstarter.base.BasePresenter
import com.irfan_berasbdg.mvpstarter.base.BaseView
import com.irfan_berasbdg.mvpstarter.data.model.Movie

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