package id.gits.gitsmvpkotlingooglebase.base

/**
 * Created by irfanirawansukirman on 12/03/18.
 */
data class BaseApiResponse<T>(
        var page: Int,
        var total_results: Int,
        var total_pages: Int,
        var results: T? = null

        //Todo code above just for testing. Change it with real base response from API
)