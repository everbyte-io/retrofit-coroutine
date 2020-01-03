package io.everbyte.apicoroutine.network

import io.everbyte.apicoroutine.model.ImageDataResponseBody
import io.everbyte.apicoroutine.model.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Thomas Chen on 24-12-2019.
 */

interface ApiService {

    @GET("image/sogou/api.php")
    suspend fun getImage(@Query("type") type: String = "json"): ImageDataResponseBody

//    @GET("image/sogou/api.php")
//    suspend fun getImage(@Query("type") type: String = "json"): ResponseBody<ImageDataResponseBody>

}