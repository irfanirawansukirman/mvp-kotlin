package com.irfan_berasbdg.mvpstarter.util

import android.content.Context
import com.irfan_berasbdg.mvpstarter.data.source.jobs.movie.MovieRepository
import com.irfan_berasbdg.mvpstarter.data.source.remote.MovieRemoteDataSource

/**
 * Created by irfanirawansukirman on 12/03/18.
 */
object Injection {
    fun provideMoviesRepository(context: Context) = MovieRepository.getInstance(MovieRemoteDataSource, MovieRemoteDataSource)
}