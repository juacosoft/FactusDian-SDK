package com.martinezdev.factusdian.network

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.martinezdev.factusdian.sdk.models.FactusCreateInvoiceRequest
import com.martinezdev.factusdian.sdk.models.FactusDataInvoicesResponse
import com.martinezdev.factusdian.sdk.models.FactusGetFactDocumentResponse
import com.martinezdev.factusdian.sdk.models.FactusGetInvoiceResponse
import com.martinezdev.factusdian.sdk.models.FactusGetInvoicesResponse
import com.martinezdev.factusdian.sdk.models.FactusListInvoiceResponse
import com.martinezdev.factusdian.sdk.network.InvoiceService
import com.martinezdev.factusdian.sdk.services.FactusCommonClient
import com.martinezdev.factusdian.sdk.utils.ApiCallHandler
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class InvoiceServiceTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()


    @MockK
    private lateinit var apiCallHandler: ApiCallHandler

    @MockK
    private lateinit var factusCommonClient: FactusCommonClient

    private lateinit var invoiceService: InvoiceService

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        Dispatchers.setMain(StandardTestDispatcher())
        invoiceService = InvoiceService(
            baseUrl = "http://localhost:8080",
            isDebugMode = true,
            apiCallHandler = apiCallHandler
        )

        invoiceService.factusCommonClient = factusCommonClient
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `GIVEN getInvoices WHEN getInvoices is Success THEN should be FactusGetInvoicesResponse`() = runTest{
        val token = "token"
        val tokenType = "tokenType"
        val page = 1
        val invoicesmock: List<FactusListInvoiceResponse> = listOf(mockk())
        val dataMock: FactusDataInvoicesResponse = mockk() {
            every { invoices } returns invoicesmock
        }
        val response = mockk<FactusGetInvoicesResponse>() {
            every { data } returns dataMock
        }

        coEvery { factusCommonClient.factusInvoiceApi(token, tokenType).getInvoices(page) } returns Response.success(response)

        val result = invoiceService.getInvoices(token, tokenType, page)

        assert(result.isSuccess)
        assert(result.getOrNull() == response)
    }

    @Test
    fun `GIVEN getInvoices WHEN getInvoices is Failure THEN should be FactusGetInvoicesResponse`() = runTest {
        val token = "token"
        val tokenType = "tokenType"
        val page = 1

        coEvery {
            factusCommonClient.factusInvoiceApi(token, tokenType).getInvoices(page)
        } returns Response.error(401, mockk(relaxed = true))

        val result = invoiceService.getInvoices(token, tokenType, page)

        assert(result.isFailure)
    }

    @Test
    fun `GIVEN getInvoice WHEN getInvoice is Success THEN should be FactusGetInvoiceResponse`() = runTest {
        val token = "token"
        val tokenType = "tokenType"
        val number = "0123"

        val response = mockk<FactusGetInvoiceResponse>()

        coEvery { factusCommonClient.factusInvoiceApi(token, tokenType).getInvoice(number) } returns Response.success(response)

        val result = invoiceService.getInvoice(token, tokenType, number)

        assert(result.isSuccess)
        assert(result.getOrNull() == response)
    }

    @Test
    fun `GIVEN getInvoice WHEN getInvoice is Failure THEN should be FactusGetInvoiceResponse`() = runTest {
        val token = "token"
        val tokenType = "tokenType"
        val number = "0123"

        coEvery { factusCommonClient.factusInvoiceApi(token, tokenType).getInvoice(number) } returns Response.error(401, mockk(relaxed = true))

        val result = invoiceService.getInvoice(token, tokenType, number)

        assert(result.isFailure)
    }

    @Test
    fun `GIVEN createInvoice WHEN createInvoice is Success THEN should be FactusCreateInvoiceResponse`() = runTest {
        val token = "token"
        val tokenType = "tokenType"

        val factusCreateInvoiceRequest: FactusCreateInvoiceRequest = mockk()

        coEvery { factusCommonClient.factusInvoiceApi(token, tokenType).postInvoice(factusCreateInvoiceRequest) } returns Response.success(mockk())

        val result = invoiceService.createInvoice(token, tokenType, factusCreateInvoiceRequest)

        assert(result.isSuccess)
        assertNotNull(result.getOrNull())
    }

    @Test
    fun `GIVEN createInvoice WHEN createInvoice is Failure THEN should be FactusCreateInvoiceResponse`() = runTest {
        val token = "token"
        val tokenType = "tokenType"

        coEvery { factusCommonClient.factusInvoiceApi(token, tokenType).postInvoice(any()) } returns Response.error(401, mockk(relaxed = true))

        val result = invoiceService.createInvoice(token, tokenType, mockk())

        assert(result.isFailure)

    }

    @Test
    fun `GIVEN downloadFactPDF WHEN downloadFactPDF is Success THEN should be FactusGetFactDocumentResponse`() = runTest {
        val token = "token"
        val tokenType = "tokenType"
        val number = "0123"

        val response = mockk<FactusGetFactDocumentResponse>()

        coEvery { factusCommonClient.factusInvoiceApi(token, tokenType).dowloadFactPDF(number) } returns Response.success(response)

        val result = invoiceService.downloadFactPDF(token, tokenType, number)

        assert(result.isSuccess)
        assert(result.getOrNull() == response)

    }

    @Test
    fun `GIVEN downloadFactPDF WHEN downloadFactPDF is Failure THEN should be FactusGetFactDocumentResponse`() = runTest {
        val token = "token"
        val tokenType = "tokenType"
        val number = "0123"

        coEvery { factusCommonClient.factusInvoiceApi(token, tokenType).dowloadFactPDF(number) } returns Response.error(401, mockk(relaxed = true))

        val result = invoiceService.downloadFactPDF(token, tokenType, number)

        assert(result.isFailure)

    }




}