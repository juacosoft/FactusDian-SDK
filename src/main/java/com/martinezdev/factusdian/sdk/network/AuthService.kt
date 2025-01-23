package com.martinezdev.factusdian.sdk.network

import com.martinezdev.factusdian.sdk.models.AuthResponseModel
import com.martinezdev.factusdian.sdk.services.AuthClient
import com.martinezdev.factusdian.sdk.utils.ApiCallHandler

internal class AuthService(
    private val baseUrl: String,
    private val clientId: String,
    private val clientSecret: String,
    private val isDebugMode: Boolean,
    private val apiCallHandler: ApiCallHandler
) {
    private val authClient = AuthClient(baseUrl, isDebugMode)

    suspend fun getAuthToken(user: String, pass: String): Result<AuthResponseModel> {
        return apiCallHandler.safeApiCall(
            call = {
                authClient.fatusAuthApi.getAuthToken(
                    username = user,
                    password = pass,
                    clientId = clientId,
                    clientSecret = clientSecret
                )
            },
            handleError = { response ->
                if (response.isSuccessful) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(Exception("Error getting token"))
                }
            }
        )
    }

    suspend fun refreshToken(refreshToken: String): Result<AuthResponseModel> {
        return apiCallHandler.safeApiCall(
            call = {
                authClient.fatusAuthApi.refreshToken(
                    refreshToken = refreshToken,
                    clientId = clientId,
                    clientSecret = clientSecret
                )
            },
            handleError = { response ->
                if (response.isSuccessful) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(Exception("Error refreshing token"))
                }
            }
        )
    }
}
