package id.gits.gitsmvpkotlingooglebase.data.source.remote

import id.gits.gitsmvpkotlingooglebase.base.BaseApiResponse
import id.gits.gitsmvpkotlingooglebase.data.model.Movie
import id.gits.gitsmvpkotlingooglebase.data.source.ApiService
import id.gits.gitsmvpkotlingooglebase.data.source.jobs.movie.MovieDataSource
import id.gits.gitsmvpkotlingooglebase.util.ScheduleUtils
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