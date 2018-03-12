package id.gits.gitsmvpkotlingooglebase.data.source

import id.gits.gitsmvpkotlingooglebase.BuildConfig
import id.gits.gitsmvpkotlingooglebase.base.BaseApiResponse
import id.gits.gitsmvpkotlingooglebase.data.model.Movie
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

/**
 * Created by irfanirawansukirman on 12/03/18.
 */
interface ApiService {
    /**
     * Do get movie list with this path
     */
    @GET("3/discover/movie?api_key=1b2f29d43bf2e4f3142530bc6929d341&sort_by=popularity.desc")
    fun getMovies(): Observable<BaseApiResponse<List<Movie>>>

    /**
     * Instance of service retrofit
     */
    companion object {

        fun createInstance(): ApiService {

            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build()

            val retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.MAIN_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(httpClient) // Todo Comment this line if you set production
                    .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}