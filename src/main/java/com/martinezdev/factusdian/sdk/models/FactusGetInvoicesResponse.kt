package com.martinezdev.factusdian.sdk.models

import com.google.gson.annotations.SerializedName

data class FactusGetInvoicesResponse(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: FactusDataInvoicesResponse
)

data class FactusDataInvoicesResponse(
    @SerializedName("data") val invoices: List<FactusListInvoiceResponse>,
    @SerializedName("pagination") val pagination: FactusPaginationResponse
)

data class FactusListInvoiceResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("document") val document: FactusGetInvoicesDocument,
    @SerializedName("number") val number: String,
    @SerializedName("api_client_name") val apiClientName: String,
    @SerializedName("reference_code") val referenceCode: String?,
    @SerializedName("identification") val identification: String,
    @SerializedName("graphic_representation_name") val graphicRepresentationName: String,
    @SerializedName("company") val company: String,
    @SerializedName("trade_name") val tradeName: String,
    @SerializedName("names") val names: String,
    @SerializedName("email") val email: String,
    @SerializedName("total") val total: String,
    @SerializedName("status") val status: Int,
    @SerializedName("errors") val errors: List<String>,
    @SerializedName("send_email") val sendEmail: Int,
    @SerializedName("has_claim") val hasClaim: Int,
    @SerializedName("is_negotiable_instrument") val isNegotiableInstrument: Int,
    @SerializedName("payment_form") val paymentForm: FactusGetInvoicesPaymentForm,
    @SerializedName("created_at") val createdAt: String?,
    @SerializedName("credit_notes") val creditNotes: List<Any>?,
    @SerializedName("debit_notes") val debitNotes: List<Any>?
)

data class FactusGetInvoicesDocument(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
)

data class FactusGetInvoicesPaymentForm(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
)

data class FactusPaginationResponse(
    @SerializedName("total") val total: Int,
    @SerializedName("per_page") val perPage: Int,
    @SerializedName("current_page") val currentPage: Int,
    @SerializedName("last_page") val lastPage: Int,
    @SerializedName("from") val from: Int?,
    @SerializedName("to") val to: Int?,
    @SerializedName("links") val links: List<FactusPaginationLink>
)

data class FactusPaginationLink(
    @SerializedName("url") val url: String?,
    @SerializedName("label") val label: String,
    @SerializedName("active") val active: Boolean
)
