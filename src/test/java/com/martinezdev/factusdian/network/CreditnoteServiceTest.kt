package com.martinezdev.factusdian.network

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.martinezdev.factusdian.sdk.models.FactusGetCreditNotePDFResponse
import com.martinezdev.factusdian.sdk.models.FactusGetCreditNotesResponse
import com.martinezdev.factusdian.sdk.network.CreditnoteService
import com.martinezdev.factusdian.sdk.services.FactusCommonClient
import com.martinezdev.factusdian.sdk.utils.ApiCallHandler
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class CreditnoteServiceTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var apiCallHandler: ApiCallHandler

    @MockK
    private lateinit var client: FactusCommonClient

    private lateinit var creditnoteService: CreditnoteService

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(StandardTestDispatcher())
        creditnoteService = CreditnoteService(
            baseUrl = "http://localhost:8080",
            isDebugMode = true,
            apiCallHandler = apiCallHandler
        )
        creditnoteService.factusCommonClient = client
    }

    @Test
    fun `GIVEN getCreditNotes WHEN getCreditNotes is Success THEN should be FactusGetCreditNotesResponse`() = runTest {
        val token = "user"
        val tokenType = "pass"
        val page = 1
        val responsemock = mockk<FactusGetCreditNotesResponse>()

        coEvery { client.getCreditNotesApi(token, tokenType).getCreditNotes(page) } returns Response.success(responsemock)

        val result = creditnoteService.getCreditNotes(token, tokenType, page)

        coVerify { client.getCreditNotesApi(eq(token), tokenType).getCreditNotes(eq(page)) }

        assert(result.isSuccess)
        assert(result.getOrNull() == responsemock)
    }

    @Test
    fun `GIVEN getCreditNotes WHEN getCreditNotes is Failure THEN should be FactusGetCreditNotesResponse`() = runTest {
        val token = "user"
        val tokenType = "pass"
        val page = 1

        coEvery { client.getCreditNotesApi(token, tokenType).getCreditNotes(page) } returns Response.error(404, mockk(relaxed = true))

        val result = creditnoteService.getCreditNotes(token, tokenType, page)

        coVerify { client.getCreditNotesApi(eq(token), tokenType).getCreditNotes(eq(page)) }

        assert(result.isFailure)

    }

    @Test
    fun `GIVEN getCreditNotePDF WHEN getCreditNotePDF is Success THEN should be FactusGetCreditNotePDFResponse`() = runTest {
        val token = "user"
        val tokenType = "pass"
        val number = "123"

        val responsemock = mockk<FactusGetCreditNotePDFResponse>()

        coEvery { client.getCreditNotesApi(token, tokenType).getCreditNotePDF(number) } returns Response.success(responsemock)

        val result = creditnoteService.getCreditNotePDF(token, tokenType, number)

        coVerify { client.getCreditNotesApi(eq(token), tokenType).getCreditNotePDF(eq(number)) }

        assert(result.isSuccess)
        assert(result.getOrNull() == responsemock)
    }

    @Test
    fun `GIVEN getCreditNotePDF WHEN getCreditNotePDF is Failure THEN should be FactusGetCreditNotePDFResponse`() = runTest {
        val token = "user"
        val tokenType = "pass"
        val number = "123"

        coEvery { client.getCreditNotesApi(token, tokenType).getCreditNotePDF(number) } returns Response.error(404, mockk(relaxed = true))

        val result = creditnoteService.getCreditNotePDF(token, tokenType, number)

        coVerify { client.getCreditNotesApi(eq(token), tokenType).getCreditNotePDF(eq(number)) }

        assert(result.isFailure)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}