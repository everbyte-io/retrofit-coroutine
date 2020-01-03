package io.everbyte.apicoroutine.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

/**
 * Created by Thomas Chen on 24-12-2019.
 */

object NetworkService {

    private const val BASE_URL = "https://api.ooopn.com/"

    private val retrofit = Retrofit.Builder()
        .client(OkHttpClient.Builder().callTimeout(10, TimeUnit.SECONDS).build())
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create<ApiService>()

}