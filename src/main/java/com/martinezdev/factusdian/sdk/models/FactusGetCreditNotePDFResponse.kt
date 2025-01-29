package com.martinezdev.factusdian.sdk.models

import com.google.gson.annotations.SerializedName

data class FactusGetCreditNotePDFResponse(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: FactusGetCreditPDFNoteData
)


data class FactusGetCreditPDFNoteData(
    @SerializedName("file_name") val fileName: String,
    @SerializedName("pdf_base_64_encoded") val pdfBase64Encoded: String
)