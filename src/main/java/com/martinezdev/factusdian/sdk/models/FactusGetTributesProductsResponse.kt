package com.martinezdev.factusdian.sdk.models

import com.google.gson.annotations.SerializedName

data class FactusGetTributesProductsResponse(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: List<FactusGetTributesProductsTaxResponse>
)

data class FactusGetTributesProductsTaxResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String
)
