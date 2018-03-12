package id.gits.gitsmvpkotlingooglebase.mvp.main

import id.gits.gitsmvpkotlingooglebase.data.model.Movie
import id.gits.gitsmvpkotlingooglebase.data.source.jobs.movie.MovieDataSource
import id.gits.gitsmvpkotlingooglebase.data.source.jobs.movie.MovieRepository

/**
 * Created by irfanirawansukirman on 12/03/18.
 */
class MainPresenter(private val moviesRepository: MovieRepository, private val moviesView: MainContract.View) : MainContract.Presenter {

    init {
        moviesView.presenter = this
    }

    override fun start() {
        loadMovies()
    }

    override fun clearDisposable() {
        moviesRepository.clearDisposable()
    }

    override fun loadMovies() {
        moviesView.showProgress()
        moviesRepository.getMovies(object : MovieDataSource.LoadMoviesCallback {
            override fun onMoviesLoaded(movies: List<Movie>) {
                if (movies.isNotEmpty()) {
                    moviesView.showMovies(movies)
                }
            }

            override fun onFailed(errorMessage: String) {
                moviesView.onFailed(errorMessage)
            }
        })

        moviesView.hideProgress()
    }

    override fun openMovieDetail(movie: Movie) {

    }
}