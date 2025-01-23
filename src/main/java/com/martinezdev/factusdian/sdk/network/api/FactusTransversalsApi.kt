package com.martinezdev.factusdian.sdk.network.api

import com.martinezdev.factusdian.sdk.models.FactusGetCreditNotesResponse
import com.martinezdev.factusdian.sdk.models.FactusGetMunicipalitysResponse
import com.martinezdev.factusdian.sdk.models.FactusGetTributesProductsResponse
import com.martinezdev.factusdian.sdk.models.FactusGetUnitsResponse
import com.martinezdev.factusdian.sdk.models.FactusNumeringRangeResponse
import retrofit2.Response
import retrofit2.http.GET

interface FactusTransversalsApi {

    @GET("v1/municipalities/municipalities/")
    suspend fun getMunicipalities(): Response<FactusGetMunicipalitysResponse>

    @GET("v1/numbering-ranges/")
    suspend fun getNumeringRanges(): Response<FactusNumeringRangeResponse>

    @GET("v1/tributes/products/")
    suspend fun getTributesProducts(): Response<FactusGetTributesProductsResponse>

    @GET("v1/measurement-units/")
    suspend fun getGetUnitsResponse(): Response<FactusGetUnitsResponse>

    @GET("v1/credit-notes/")
    suspend fun getCreditNotes(): Response<FactusGetCreditNotesResponse>
}