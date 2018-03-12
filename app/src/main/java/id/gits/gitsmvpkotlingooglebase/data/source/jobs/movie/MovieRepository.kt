package id.gits.gitsmvpkotlingooglebase.data.source.jobs.movie

import id.gits.gitsmvpkotlingooglebase.data.model.Movie

/**
 * Created by irfanirawansukirman on 12/03/18.
 */
class MovieRepository(
        val moviesRemoteDataSource: MovieDataSource,
        val moviesLocalDataSource: MovieDataSource
) : MovieDataSource {

    override fun getMovies(callback: MovieDataSource.LoadMoviesCallback) {
        moviesRemoteDataSource.getMovies(object : MovieDataSource.LoadMoviesCallback {
            override fun onMoviesLoaded(movies: List<Movie>) {
                callback.onMoviesLoaded(movies)
            }

            override fun onFailed(errorMessage: String) {
                callback.onFailed(errorMessage)
            }
        })
    }

    override fun getMovie(title: String) {

    }

    override fun clearDisposable() {
        moviesRemoteDataSource.clearDisposable()
    }

    companion object {
        private var INSTANCE : MovieRepository? = null

        @JvmStatic fun getInstance(moviesRemoteDataSource: MovieDataSource,
                                   moviesLocalDataSource: MovieDataSource): MovieRepository {
            return INSTANCE ?: MovieRepository(moviesRemoteDataSource, moviesLocalDataSource)
                    .apply { INSTANCE = this }
        }
    }
}