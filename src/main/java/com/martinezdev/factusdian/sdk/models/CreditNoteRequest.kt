package com.martinezdev.factusdian.sdk.models

import com.google.gson.annotations.SerializedName

data class CreditNoteRequest (
    @SerializedName("numbering_range_id") val numberingRangeId: Int,
    @SerializedName("correction_concept_code") val correctionConceptCode: Int,
    @SerializedName("customization_id") val customizationId: Int,
    @SerializedName("bill_id") val billId: Int,
    @SerializedName("reference_code") val referenceCode: String,
    @SerializedName("observation") val observation: String,
    @SerializedName("payment_method_code") val paymentMethodCode: String,
    @SerializedName("items") val items: List<CreditNoteItemRequest>
)

data class CreditNoteItemRequest(
    @SerializedName("code_reference") val codeReference: String,
    @SerializedName("name") val name: String,
    @SerializedName("quantity") val quantity: Int,
    @SerializedName("discount_rate") val discountRate: Int,
    @SerializedName("price") val price: Int,
    @SerializedName("tax_rate") val taxRate: String,
    @SerializedName("unit_measure_id") val unitMeasureId: Int,
    @SerializedName("standard_code_id") val standardCodeId: Int,
    @SerializedName("is_excluded") val isExcluded: Int,
    @SerializedName("tribute_id") val tributeId: Int,
    @SerializedName("withholding_taxes") val withholdingTaxes: List<Any> ?= null
)