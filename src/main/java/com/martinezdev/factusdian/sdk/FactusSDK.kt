package com.martinezdev.factusdian.sdk

import android.util.Log
import com.martinezdev.factusdian.sdk.models.AuthResponseModel
import com.martinezdev.factusdian.sdk.models.FactusCreateInvoiceRequest
import com.martinezdev.factusdian.sdk.models.FactusCreateInvoiceResponse
import com.martinezdev.factusdian.sdk.models.FactusGetCreditNotePDFResponse
import com.martinezdev.factusdian.sdk.models.FactusGetCreditNotesResponse
import com.martinezdev.factusdian.sdk.models.FactusGetFactDocumentResponse
import com.martinezdev.factusdian.sdk.models.FactusGetInvoicesResponse
import com.martinezdev.factusdian.sdk.models.FactusGetMunicipalitysResponse
import com.martinezdev.factusdian.sdk.models.FactusGetTributesProductsResponse
import com.martinezdev.factusdian.sdk.models.FactusGetUnitsResponse
import com.martinezdev.factusdian.sdk.models.FactusNumeringRangeResponse
import com.martinezdev.factusdian.sdk.network.AuthService
import com.martinezdev.factusdian.sdk.network.CreditnoteService
import com.martinezdev.factusdian.sdk.network.FactusTransversalsService
import com.martinezdev.factusdian.sdk.network.InvoiceService
import com.martinezdev.factusdian.sdk.utils.ApiCallHandler

object FactusSDK {

    private lateinit var authService: AuthService
    private lateinit var invoiceService: InvoiceService
    private lateinit var transversalsService: FactusTransversalsService
    private lateinit var creditnoteService: CreditnoteService
    private lateinit var apiCallHandler: ApiCallHandler

    private lateinit var baseUrl: String
    private lateinit var clientSecret: String
    private lateinit var clientId: String
    private var isDebugMode = false

    /**
     * Initializes the SDK with the given parameters.
     *
     * @param baseUrl The base URL of the API.
     * @param clientId The client ID.
     * @param clientSecret The client secret.
     * @param isDebugMode Whether the SDK should run in debug mode.
     */

    fun initialize(
        baseUrl: String,
        clientId: String,
        clientSecret: String,
        isDebugMode: Boolean = false
    ) {
        this.baseUrl = baseUrl
        this.clientId = clientId
        this.clientSecret = clientSecret
        this.isDebugMode = isDebugMode

        apiCallHandler = ApiCallHandler()
        authService = AuthService(baseUrl, clientId, clientSecret, isDebugMode, apiCallHandler)
        invoiceService = InvoiceService(baseUrl, isDebugMode, apiCallHandler)
        creditnoteService = CreditnoteService(baseUrl, isDebugMode, apiCallHandler)
        transversalsService = FactusTransversalsService(baseUrl, isDebugMode, apiCallHandler)
        Log.d("Factus SDK", "initialized")
    }

    // region Auth

    /**
     * Gets an auth token for the given user and password.
     *
     * @param user The user.
     * @param pass The password.
     * @return The result of the operation.
     */
    suspend fun getAuthToken(user: String, pass: String): Result<AuthResponseModel> {
        ensureInitialized()
        return authService.getAuthToken(user, pass)
    }

    /**
     * Refreshes the auth token.
     *
     * @param refreshToken The refresh token.
     * @return The result of the operation.
     */
    suspend fun refreshToken(refreshToken: String):Result<AuthResponseModel> {
        ensureInitialized()
        return authService.refreshToken(refreshToken)
    }

    // endregion

    // region Invoices

    /**
     * Gets the invoice with the given number.
     *
     * @param token The auth token.
     * @param tokenType The token type.
     * @param number The invoice number.
     * @return The result of the operation.
     */
    suspend fun getInvoices(token: String, tokenType: String, page: Int): Result<FactusGetInvoicesResponse> {
        ensureInitialized()
        return invoiceService.getInvoices(token, tokenType, page)
    }

    /**
     * Gets the invoice with the given number.
     *
     * @param token The auth token.
     * @param tokenType The token type.
     * @param number The invoice number.
     * @return The result of the operation.
     */
    suspend fun createInvoice(token: String, tokenType: String, request: FactusCreateInvoiceRequest) : Result<FactusCreateInvoiceResponse>{
        ensureInitialized()
        return invoiceService.createInvoice(token, tokenType, request)
    }

    /**
     * Gets the invoice with the given number.
     *
     * @param token The auth token.
     * @param tokenType The token type.
     * @param number The invoice number.
     * @return The result of the operation.
     */
    suspend fun downloadFactPDF(token: String, tokenType: String, number: String): Result<FactusGetFactDocumentResponse> {
        ensureInitialized()
        return invoiceService.downloadFactPDF(token, tokenType, number)
    }

    // endregion

    // region transversals

    /**
     * Gets the invoice with the given number.
     *
     * @param token The auth token.
     * @param tokenType The token type.
     * @param number The invoice number.
     * @return The result of the operation.
     */
    suspend fun getMunicipalities(token: String, tokenType: String): Result<FactusGetMunicipalitysResponse> {
        ensureInitialized()
        return transversalsService.getMunicipalities(token, tokenType)
    }

    /**
     * Gets the invoice with the given number.
     *
     * @param token The auth token.
     * @param tokenType The token type.
     * @param number The invoice number.
     * @return The result of the operation.
     */
    suspend fun getNumeringRanges(token: String, tokenType: String): Result<FactusNumeringRangeResponse> {
        ensureInitialized()
        return transversalsService.getNumeringRanges(token, tokenType)
    }
    /**
     * Gets the invoice with the given number.
     *
     * @param token The auth token.
     * @param tokenType The token type.
     * @param number The invoice number.
     * @return The result of the operation.
     */
    suspend fun getTributesProducts(token: String, tokenType: String): Result<FactusGetTributesProductsResponse> {
        ensureInitialized()
        return transversalsService.getTributesProducts(token, tokenType)
    }

    /**
     * Gets the invoice with the given number.
     *
     * @param token The auth token.
     * @param tokenType The token type.
     * @param number The invoice number.
     * @return The result of the operation.
     */
    suspend fun getMeasureUnits(token: String, tokenType: String): Result<FactusGetUnitsResponse> {
        ensureInitialized()
        return transversalsService.getMeasureUnits(token, tokenType)
    }

    // endregion

    // region Credit Notes

    /**
     * Gets the invoice with the given number.
     *
     * @param token The auth token.
     * @param tokenType The token type.
     * @param number The invoice number.
     * @return The result of the operation.
     */
    suspend fun getCreditNotes(token: String, tokenType: String): Result<FactusGetCreditNotesResponse> {
        ensureInitialized()
        return transversalsService.getCreditNotes(token, tokenType)
    }

    /**
     * Gets the invoice with the given number.
     *
     * @param token The auth token.
     * @param tokenType The token type.
     * @param page the page to list.
     * @return The result of the operation.
     */
    suspend fun getCreditNotes(token: String, tokenType: String, page: Int): Result<FactusGetCreditNotesResponse> {
        ensureInitialized()
        return creditnoteService.getCreditNotes(token, tokenType, page)
    }

    /**
     * Gets the invoice with the given number.
     *
     * @param token The auth token.
     * @param tokenType The token type.
     * @param number The credit note number.
     * @return The result of the operation.
     */
    suspend fun getCreditNotePDF(token: String, tokenType: String, number: String): Result<FactusGetCreditNotePDFResponse> {
        ensureInitialized()
        return creditnoteService.getCreditNotePDF(token, tokenType, number)
    }

    // endregion

    private fun ensureInitialized() {
        if (!::authService.isInitialized
            || !::invoiceService.isInitialized
            || !::transversalsService.isInitialized
            || !::creditnoteService.isInitialized
            ) {
            throw IllegalStateException("SDK not initialized. Call initialize() first.")
        }
    }
}
