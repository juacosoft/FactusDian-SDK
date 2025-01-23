package com.martinezdev.factusdian.sdk.models

import com.google.gson.annotations.SerializedName

data class FactusNumeringRangeResponse(
    @SerializedName("data") val data: List<FactusRagenNumbers>
)

data class FactusRagenNumbers(
    @SerializedName("id") val id: Int,
    @SerializedName("document") val document: String,
    @SerializedName("prefix") val prefix: String,
    @SerializedName("from") val from: Long,
    @SerializedName("to") val to: Long,
    @SerializedName("current") val current: Long,
    @SerializedName("resolution_number") val resolutionNumber: String,
    @SerializedName("start_date") val startDate: String,
    @SerializedName("end_date") val endDate: String,
    @SerializedName("technical_key") val technicalKey: String?,
    @SerializedName("is_expired") val isExpired: Boolean,
    @SerializedName("is_active") val isActive: Int,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String
)
