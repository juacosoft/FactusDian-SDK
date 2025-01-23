package com.martinezdev.factusdian.sdk.network.api

import com.martinezdev.factusdian.sdk.models.FactusCreateInvoiceRequest
import com.martinezdev.factusdian.sdk.models.FactusCreateInvoiceResponse
import com.martinezdev.factusdian.sdk.models.FactusGetFactDocumentResponse
import com.martinezdev.factusdian.sdk.models.FactusGetInvoiceResponse
import com.martinezdev.factusdian.sdk.models.FactusGetInvoicesResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

internal interface FactusInvoiceApi {

    @POST("v1/bills/validate/")
    suspend fun postInvoice(
        @Body factusCreateInvoiceRequest: FactusCreateInvoiceRequest
    ): Response<FactusCreateInvoiceResponse>

    @GET("v1/bills/")
    suspend fun getInvoices(
        @Query("page") page: Int,
    ): Response<FactusGetInvoicesResponse>

    @GET("v1/bills/show/{number}")
    suspend fun getInvoice(
        @Path("number") number: String
    ): Response<FactusGetInvoiceResponse>

    @GET("v1/bills/download-pdf/{number}")
    suspend fun dowloadFactPDF(
        @Path("number") number: String
    ): Response<FactusGetFactDocumentResponse>
}