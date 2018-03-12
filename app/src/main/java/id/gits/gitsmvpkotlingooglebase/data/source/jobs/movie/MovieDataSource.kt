package id.gits.gitsmvpkotlingooglebase.data.source.jobs.movie

import id.gits.gitsmvpkotlingooglebase.data.model.Movie

/**
 * Created by irfanirawansukirman on 12/03/18.
 */
interface MovieDataSource {

    /**
     * Callback view for load all movie
     */
    interface LoadMoviesCallback {
        fun onMoviesLoaded(movies: List<Movie>)
        fun onFailed(errorMessage: String)
    }

    /**
     * Callback view for getting item movie
     */
    interface GetMovieCallback {
        fun onMovieLoaded(movie: Movie)
        fun onFailed(errorMessage: String)
    }

    fun getMovies(callback: LoadMoviesCallback)
    fun getMovie(title: String)
    fun clearDisposable()
}