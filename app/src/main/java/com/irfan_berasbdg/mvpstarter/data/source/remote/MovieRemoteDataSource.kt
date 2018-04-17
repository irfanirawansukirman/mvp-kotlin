package com.irfan_berasbdg.mvpstarter.data.source.remote

import com.irfan_berasbdg.mvpstarter.base.BaseApiResponse
import com.irfan_berasbdg.mvpstarter.data.model.Movie
import com.irfan_berasbdg.mvpstarter.data.source.ApiService
import com.irfan_berasbdg.mvpstarter.data.source.jobs.movie.MovieDataSource
import com.irfan_berasbdg.mvpstarter.util.ScheduleUtils
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by irfanirawansukirman on 12/03/18.
 */
object MovieRemoteDataSource : MovieDataSource {

    private val apiService = ApiService.createInstance()
    private var compositeDisposable: CompositeDisposable? = null

    override fun getMovies(callback: MovieDataSource.LoadMoviesCallback) {
        addSubscribe(apiService.getMovies()
                .compose(ScheduleUtils.set<BaseApiResponse<List<Movie>>>())
                .subscribe({ data ->
                    data.let {
                        callback.onMoviesLoaded(it.results!!)
                    }
                }, { error ->
                    callback.onFailed(error.message!!)
                    clearSubscribe()
                })
        )
    }

    override fun getMovie(title: String) {

    }

    override fun clearDisposable() {
        clearSubscribe()
    }

    private fun addSubscribe(disposable: Disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
            compositeDisposable!!.add(disposable)
        }
    }

    private fun clearSubscribe() {
        if (compositeDisposable != null) {
            compositeDisposable!!.clear()
        }
    }
}