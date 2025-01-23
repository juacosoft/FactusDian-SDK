package com.martinezdev.factusdian.sdk.services

import com.martinezdev.factusdian.sdk.network.api.FatusAuthApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class AuthClient(
    private val baseUrl: String,
    private val isDebugMode: Boolean
) {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        if (isDebugMode) level = HttpLoggingInterceptor.Level.BODY
    }

    private val headerinterceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("Accept", "application/json")
            .build()
        chain.proceed(request)
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(headerinterceptor)
        .build()

    val fatusAuthApi: FatusAuthApi by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FatusAuthApi::class.java)
    }
}