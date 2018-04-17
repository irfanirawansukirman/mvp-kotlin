package id.gits.gitsmvpkotlingooglebase.data.source.jobs.movie

import id.gits.gitsmvpkotlingooglebase.data.model.Movie

/**
 * Created by irfanirawansukirman on 12/03/18.
 */
interface MovieDataSource {

    interface LoadMoviesCallback {
        fun onMoviesLoaded(movies: List<Movie>)
        fun onFailed(errorMessage: String)
    }

    fun getMovies(callback: LoadMoviesCallback)
    fun getMovie(title: String)
    fun clearDisposable()
}