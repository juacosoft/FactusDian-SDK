package com.martinezdev.factusdian.sdk.network.api

import com.martinezdev.factusdian.sdk.models.CreditNoteRequest
import com.martinezdev.factusdian.sdk.models.FactusGetCreditNotePDFResponse
import com.martinezdev.factusdian.sdk.models.FactusGetCreditNotesResponse
import com.martinezdev.factusdian.sdk.models.FactusPostCreditNoteResponse
import com.martinezdev.factusdian.sdk.models.GetCreditNoteResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface CreditNoteApi {

    @GET("v1/credit-notes/")
    suspend fun getCreditNotes(
        @Query("page") page: Int
    ): Response<FactusGetCreditNotesResponse>

    @GET("vv1/credit-notes/download-pdf/{number}/")
    suspend fun getCreditNotePDF(
        @Path("number") number: String
    ): Response<FactusGetCreditNotePDFResponse>

    @POST("/v1/credit-notes/{number}")
    suspend fun postCreditNote(
        @Path("number") number: String
    ): Response<GetCreditNoteResponse>

    @POST("/v1/credit-notes/validate/")
    suspend fun postValidateCreditNote(
        @Body request: CreditNoteRequest
    ): Response<FactusPostCreditNoteResponse>
}