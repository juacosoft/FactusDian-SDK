package com.martinezdev.factusdian.sdk.models

import com.google.gson.annotations.SerializedName

data class FactusGetCreditNotesResponse(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: FactisGetCreditNoteData
)

data class FactisGetCreditNoteData(
    @SerializedName("data") val creditNotes: List<FactusGetCreditNote>,
    @SerializedName("pagination") val pagination: FactusGetCreditNotesPagination
)

data class GetCreditNoteResponse(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: FactusGetCreditNote
)

data class FactusGetCreditNote(
    @SerializedName("id") val id: Int,
    @SerializedName("api_client_name") val apiClientName: String,
    @SerializedName("number") val number: String,
    @SerializedName("identification") val identification: String,
    @SerializedName("graphic_representation_name") val graphicRepresentationName: String,
    @SerializedName("company") val company: String,
    @SerializedName("trade_name") val tradeName: String?,
    @SerializedName("names") val names: String,
    @SerializedName("email") val email: String?,
    @SerializedName("total") val total: String,
    @SerializedName("status") val status: Int,
    @SerializedName("errors") val errors: List<String>,
    @SerializedName("send_email") val sendEmail: Int,
    @SerializedName("created_at") val createdAt: String
)

data class FactusGetCreditNotesPagination(
    @SerializedName("total") val total: Int,
    @SerializedName("per_page") val perPage: Int,
    @SerializedName("current_page") val currentPage: Int,
    @SerializedName("last_page") val lastPage: Int,
    @SerializedName("from") val from: Int,
    @SerializedName("to") val to: Int,
    @SerializedName("links") val links: List<FactusGetCreditNotesPaginationLink>
)

data class FactusGetCreditNotesPaginationLink(
    @SerializedName("url") val url: String?,
    @SerializedName("label") val label: String,
    @SerializedName("page") val page: Int?,
    @SerializedName("active") val active: Boolean
)
