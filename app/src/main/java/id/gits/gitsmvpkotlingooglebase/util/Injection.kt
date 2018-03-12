package id.gits.gitsmvpkotlingooglebase.util

import android.content.Context
import id.gits.gitsmvpkotlingooglebase.data.source.jobs.movie.MovieRepository
import id.gits.gitsmvpkotlingooglebase.data.source.remote.MovieRemoteDataSource

/**
 * Created by irfanirawansukirman on 12/03/18.
 */
object Injection {
    fun provideMoviesRepository(context: Context) = MovieRepository.getInstance(MovieRemoteDataSource, MovieRemoteDataSource)
}