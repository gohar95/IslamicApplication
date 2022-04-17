package com.invotech.mrsmofficial.Object

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object APIClient {
    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://islamicbackened.herokuapp.com/islamic/api/v1/"

    val client: Retrofit
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit!!
        }

}