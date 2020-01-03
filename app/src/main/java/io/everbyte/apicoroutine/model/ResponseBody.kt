package io.everbyte.apicoroutine.model

/**
 * Created by Thomas Chen on 24-12-2019.
 */

data class ResponseBody<T>(
    val code: Int,
    val msg: String,
    val data: T
)