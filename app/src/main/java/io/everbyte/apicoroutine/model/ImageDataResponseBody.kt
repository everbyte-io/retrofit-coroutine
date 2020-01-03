package io.everbyte.apicoroutine.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Thomas Chen on 24-12-19.
 */

data class ImageDataResponseBody(
    @SerializedName("code") val code: String,
    @SerializedName("imgurl") val imageUrl: String
)