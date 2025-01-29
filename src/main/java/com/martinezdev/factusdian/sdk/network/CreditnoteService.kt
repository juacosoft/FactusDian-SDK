package com.martinezdev.factusdian.sdk.network

import androidx.annotation.VisibleForTesting
import com.martinezdev.factusdian.sdk.models.FactusGetCreditNotePDFResponse
import com.martinezdev.factusdian.sdk.models.FactusGetCreditNotesResponse
import com.martinezdev.factusdian.sdk.services.FactusCommonClient
import com.martinezdev.factusdian.sdk.utils.ApiCallHandler

internal class CreditnoteService(
    private val baseUrl: String,
    private val isDebugMode: Boolean,
    private val apiCallHandler: ApiCallHandler
) {

    @VisibleForTesting
    var factusCommonClient = FactusCommonClient(baseUrl, isDebugMode)

    suspend fun getCreditNotes(
        token: String,
        tokenType: String,
        page: Int
    ): Result<FactusGetCreditNotesResponse> {
        return apiCallHandler.safeApiCall(
            call = {
                factusCommonClient.getCreditNotesApi(token, tokenType).getCreditNotes(page)
            },
            handleError = { response ->
                apiCallHandler.getResponse(response)
            }
        )
    }

    suspend fun getCreditNotePDF(
        token: String,
        tokenType: String,
        number: String
    ): Result<FactusGetCreditNotePDFResponse> {
        return apiCallHandler.safeApiCall(
            call = {
                factusCommonClient.getCreditNotesApi(token, tokenType).getCreditNotePDF(number)
            },
            handleError = {
                apiCallHandler.getResponse(it)
            }
        )
    }
}