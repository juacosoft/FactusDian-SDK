package com.martinezdev.factusdian.sdk.network.api

import com.martinezdev.factusdian.sdk.models.AuthResponseModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

internal interface FatusAuthApi {

    @FormUrlEncoded
    @POST("oauth/token")
    suspend fun getAuthToken(
        @Field("grant_type") grantType: String = "password",
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("username") username: String,
        @Field("password") password: String
    ): Response<AuthResponseModel>

    @FormUrlEncoded
    @POST("oauth/token")
    suspend fun refreshToken(
        @Field("grant_type") grantType: String = "refresh_token",
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("refresh_token") refreshToken: String
    ): Response<AuthResponseModel>
}