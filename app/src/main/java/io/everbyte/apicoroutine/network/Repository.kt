package io.everbyte.apicoroutine.network

import io.everbyte.apicoroutine.model.ImageDataResponseBody
import io.everbyte.apicoroutine.model.ResponseBody

/**
 * Created by Thomas Chen on 24-12-2019.
 */

object Repository {

    private fun <T> processData(responseBody: ResponseBody<T>): T {
        return if (responseBody.code == 200) responseBody.data else throw Throwable(responseBody.msg)
    }

//    suspend fun getImageData(): ImageDataResponseBody {
//        val responseBody = NetworkService.apiService.getImage()
//        return processData(responseBody)
//    }
}