package com.martinezdev.factusdian.sdk.network

import androidx.annotation.VisibleForTesting
import com.martinezdev.factusdian.sdk.models.FactusGetCreditNotesResponse
import com.martinezdev.factusdian.sdk.models.FactusGetMunicipalitysResponse
import com.martinezdev.factusdian.sdk.models.FactusGetTributesProductsResponse
import com.martinezdev.factusdian.sdk.models.FactusGetUnitsResponse
import com.martinezdev.factusdian.sdk.models.FactusNumeringRangeResponse
import com.martinezdev.factusdian.sdk.services.FactusCommonClient
import com.martinezdev.factusdian.sdk.utils.ApiCallHandler

internal class FactusTransversalsService(
    private val baseUrl: String,
    private val isDebugMode: Boolean,
    private val apiCallHandler: ApiCallHandler
){

    @VisibleForTesting
    var factusCommonClient = FactusCommonClient(baseUrl, isDebugMode)

    suspend fun getMunicipalities(
        token: String,
        tokenType: String
    ): Result<FactusGetMunicipalitysResponse> {
        return apiCallHandler.safeApiCall(
            call = {
                factusCommonClient.factusTransversalsApi(token, tokenType).getMunicipalities()
            },
            handleError = { response ->
                apiCallHandler.getResponse(response)
            }
        )
    }

    suspend fun getNumeringRanges(
        token: String,
        tokenType: String
    ): Result<FactusNumeringRangeResponse> {
        return apiCallHandler.safeApiCall(
            call = {
                factusCommonClient.factusTransversalsApi(token, tokenType).getNumeringRanges()
            },
            handleError = { response ->
                apiCallHandler.getResponse(response)
            }
        )
    }

    suspend fun getTributesProducts(
        token: String,
        tokenType: String
    ): Result<FactusGetTributesProductsResponse> {
        return apiCallHandler.safeApiCall(
            call = {
                factusCommonClient.factusTransversalsApi(token, tokenType).getTributesProducts()
            },
            handleError = { response ->
                apiCallHandler.getResponse(response)
            }
        )
    }


    suspend fun getMeasureUnits(
        token: String,
        tokenType: String
    ): Result<FactusGetUnitsResponse> {
        return apiCallHandler.safeApiCall(
            call = {
                factusCommonClient.factusTransversalsApi(token, tokenType).getGetUnitsResponse()
            },
            handleError = { response ->
                apiCallHandler.getResponse(response)
            }
        )
    }

    suspend fun getCreditNotes(
        token: String,
        tokenType: String
    ): Result<FactusGetCreditNotesResponse> {
        return apiCallHandler.safeApiCall(
            call = {
                factusCommonClient.factusTransversalsApi(token, tokenType).getCreditNotes()
            },
            handleError = { response ->
                apiCallHandler.getResponse(response)
            }
        )
    }
}