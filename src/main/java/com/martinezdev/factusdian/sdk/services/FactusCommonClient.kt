package com.martinezdev.factusdian.sdk.services

import com.martinezdev.factusdian.sdk.network.api.FactusInvoiceApi
import com.martinezdev.factusdian.sdk.network.api.FactusTransversalsApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class FactusCommonClient(
    private val baseUrl: String,
    private val isDebugMode: Boolean
) {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        if (isDebugMode) level = HttpLoggingInterceptor.Level.BODY
    }

    fun factusInvoiceApi(token: String, tokenType: String): FactusInvoiceApi {
        val headerinterceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "$tokenType $token")
                .addHeader("Accept", "application/json")
                .build()
            chain.proceed(request)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(headerinterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FactusInvoiceApi::class.java)
    }

    fun factusTransversalsApi(token: String, tokenType: String): FactusTransversalsApi {
        val headerinterceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "$tokenType $token")
                .addHeader("Accept", "application/json")
                .build()
            chain.proceed(request)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(headerinterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FactusTransversalsApi::class.java)
    }
}