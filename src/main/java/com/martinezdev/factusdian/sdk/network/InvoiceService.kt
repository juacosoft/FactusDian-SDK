package com.martinezdev.factusdian.sdk.network

import androidx.annotation.VisibleForTesting
import com.martinezdev.factusdian.sdk.models.FactusCreateInvoiceRequest
import com.martinezdev.factusdian.sdk.models.FactusCreateInvoiceResponse
import com.martinezdev.factusdian.sdk.models.FactusGetFactDocumentResponse
import com.martinezdev.factusdian.sdk.models.FactusGetInvoiceResponse
import com.martinezdev.factusdian.sdk.models.FactusGetInvoicesResponse
import com.martinezdev.factusdian.sdk.services.FactusCommonClient
import com.martinezdev.factusdian.sdk.utils.ApiCallHandler

internal class InvoiceService(
    private val baseUrl: String,
    private val isDebugMode: Boolean,
    private val apiCallHandler: ApiCallHandler
) {

    @VisibleForTesting
    var factusCommonClient = FactusCommonClient(baseUrl, isDebugMode)

    suspend fun getInvoices(
        token: String,
        tokenType: String,
        page: Int
    ): Result<FactusGetInvoicesResponse> {
        return apiCallHandler.safeApiCall(
            call = {
                factusCommonClient.factusInvoiceApi(token, tokenType).getInvoices(page)
            },
            handleError = { response ->
                apiCallHandler.getResponse(response)
            }
        )
    }

    suspend fun getInvoice(
        token: String,
        tokenType: String,
        number: String
    ): Result<FactusGetInvoiceResponse>{
        return apiCallHandler.safeApiCall(
            call = {
                factusCommonClient.factusInvoiceApi(token, tokenType).getInvoice(number)
            },
            handleError = {
                apiCallHandler.getResponse(it)
            }
        )
    }

    suspend fun createInvoice(
        token: String,
        tokenType: String,
        factusCreateInvoiceRequest: FactusCreateInvoiceRequest
    ): Result<FactusCreateInvoiceResponse> {
        return apiCallHandler.safeApiCall(
            call = {
                factusCommonClient.factusInvoiceApi(token, tokenType).postInvoice(factusCreateInvoiceRequest)
            },
            handleError = { response ->
                apiCallHandler.getResponse(response)
            }
        )
    }

    suspend fun downloadFactPDF(
        token: String,
        tokenType: String,
        number: String
    ): Result<FactusGetFactDocumentResponse> {
        return apiCallHandler.safeApiCall(
            call = {
                factusCommonClient.factusInvoiceApi(token, tokenType).dowloadFactPDF(number)
            },
            handleError = { response ->
                apiCallHandler.getResponse(response)
            }
        )
    }
}
