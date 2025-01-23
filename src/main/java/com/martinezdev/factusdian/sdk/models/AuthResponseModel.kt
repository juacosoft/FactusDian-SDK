package com.martinezdev.factusdian.sdk.models

import com.google.gson.annotations.SerializedName

data class AuthResponseModel(
    @SerializedName("token_type")
    val tokenType: String,
    @SerializedName("expires_in")
    val expiresIn: Int,
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("refresh_token")
    val refreshToken: String
)
