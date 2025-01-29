package com.martinezdev.factusdian.network

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.martinezdev.factusdian.sdk.models.FactusGetCreditNotesResponse
import com.martinezdev.factusdian.sdk.models.FactusGetMunicipalitysResponse
import com.martinezdev.factusdian.sdk.models.FactusGetTributesProductsResponse
import com.martinezdev.factusdian.sdk.models.FactusGetUnitsResponse
import com.martinezdev.factusdian.sdk.models.FactusNumeringRangeResponse
import com.martinezdev.factusdian.sdk.network.FactusTransversalsService
import com.martinezdev.factusdian.sdk.services.FactusCommonClient
import com.martinezdev.factusdian.sdk.utils.ApiCallHandler
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
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
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class FactusTransversalsServiceTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var apiCallHandler: ApiCallHandler

    @MockK
    private lateinit var factusCommonClient: FactusCommonClient

    private lateinit var factusTransversalsService: FactusTransversalsService

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(StandardTestDispatcher())
        factusTransversalsService = FactusTransversalsService(
            baseUrl = "http://localhost:8080",
            isDebugMode = true,
            apiCallHandler = apiCallHandler
        )
        factusTransversalsService.factusCommonClient = factusCommonClient
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `GIVEN getMunicipalities WHEN getMunicipalities is Success THEN should be FactusGetMunicipalitysResponse`() = runTest {
        val token = "token"
        val tokenType = "tokenType"
        val response = mockk<FactusGetMunicipalitysResponse>()

        coEvery { factusCommonClient.factusTransversalsApi(token, tokenType).getMunicipalities() } returns Response.success(response)

        val result = factusTransversalsService.getMunicipalities(token, tokenType)

        coVerify {
            factusCommonClient.factusTransversalsApi(eq(token), eq(tokenType)).getMunicipalities()
        }

        assert(result.isSuccess)
        assert(result.getOrNull() == response)
    }

    @Test
    fun `GIVEN getMunicipalities WHEN getMunicipalities is Failure THEN should be FactusGetMunicipalitysResponse`() = runTest {
        val token = "token"
        val tokenType = "tokenType"

        coEvery { factusCommonClient.factusTransversalsApi(token, tokenType).getMunicipalities() }  returns Response.error(401, mockk(relaxed = true))

        val result = factusTransversalsService.getMunicipalities(token, tokenType)

        coVerify {
            factusCommonClient.factusTransversalsApi(eq(token), eq(tokenType)).getMunicipalities()
        }
        assert(result.isFailure)
    }

    @Test
    fun `GIVEN getNumeringRanges WHEN getNumeringRanges is Success THEN should be FactusNumeringRangeResponse`() = runTest {
        val token = "token"
        val tokenType = "tokenType"
        val response = mockk<FactusNumeringRangeResponse>(){
            every { data } returns listOf(mockk())
        }

        coEvery { factusCommonClient.factusTransversalsApi(token, tokenType).getNumeringRanges() } returns Response.success(response)

        val result = factusTransversalsService.getNumeringRanges(token, tokenType)

        coVerify {
            factusCommonClient.factusTransversalsApi(eq(token), eq(tokenType)).getNumeringRanges()
        }

        assert(result.isSuccess)
        assert(result.getOrNull() == response)
    }

    @Test
    fun `GIVEN getNumeringRanges WHEN getNumeringRanges is Failure THEN should be FactusNumeringRangeResponse`() = runTest {
        val token = "token"
        val tokenType = "tokenType"
        coEvery { factusCommonClient.factusTransversalsApi(token, tokenType).getNumeringRanges() } returns Response.error(401, mockk(relaxed = true))

        val result = factusTransversalsService.getNumeringRanges(token, tokenType)

        coVerify {
            factusCommonClient.factusTransversalsApi(eq(token), eq(tokenType)).getNumeringRanges()
        }

        assert(result.isFailure)
    }


    @Test
    fun `GIVEN getTributesProducts WHEN getTributesProducts is Success THEN should be FactusGetTributesProductsResponse`() = runTest {
        val token = "token"
        val tokenType = "tokenType"

        val response = mockk<FactusGetTributesProductsResponse>(){
            every { data } returns listOf(mockk())
        }

        coEvery { factusCommonClient.factusTransversalsApi(token, tokenType).getTributesProducts() } returns Response.success(response)

        val result = factusTransversalsService.getTributesProducts(token, tokenType)

        coVerify {
            factusCommonClient.factusTransversalsApi(eq(token), eq(tokenType)).getTributesProducts()
        }

        assert(result.isSuccess)
        assert(result.getOrNull() == response)
    }

    @Test
    fun `GIVEN getTributesProducts WHEN getTributesProducts is Failure THEN should be FactusGetTributesProductsResponse`() = runTest {
        val token = "token"
        val tokenType = "tokenType"

        coEvery { factusCommonClient.factusTransversalsApi(token, tokenType).getTributesProducts() } returns Response.error(401, mockk(relaxed = true))

        val result = factusTransversalsService.getTributesProducts(token, tokenType)

        coVerify {
            factusCommonClient.factusTransversalsApi(eq(token), eq(tokenType)).getTributesProducts()
        }

        assert(result.isFailure)
    }

    @Test
    fun `GIVEN getMeasureUnits WHEN getMeasureUnits is Success THEN should be FactusGetUnitsResponse`() = runTest {
        val token = "token"
        val tokenType = "tokenType"

        val response = mockk<FactusGetUnitsResponse>(){
            every { data } returns listOf(mockk())
        }

        coEvery { factusCommonClient.factusTransversalsApi(token, tokenType).getGetUnitsResponse() } returns Response.success(response)

        val result = factusTransversalsService.getMeasureUnits(token, tokenType)

        coVerify {
            factusCommonClient.factusTransversalsApi(eq(token), eq(tokenType)).getGetUnitsResponse()
        }

        assert(result.isSuccess)
        assert(result.getOrNull() == response)
    }

    @Test
    fun `GIVEN getMeasureUnits WHEN getMeasureUnits is Failure THEN should be FactusGetUnitsResponse`() = runTest {
        val token = "token"
        val tokenType = "tokenType"

        coEvery { factusCommonClient.factusTransversalsApi(token, tokenType).getGetUnitsResponse() } returns Response.error(401, mockk(relaxed = true))

        val result = factusTransversalsService.getMeasureUnits(token, tokenType)

        coVerify {
            factusCommonClient.factusTransversalsApi(eq(token), eq(tokenType)).getGetUnitsResponse()
        }

        assert(result.isFailure)
    }

    @Test
    fun `GIVEN getCreditNotes WHEN getCreditNotes is Success THEN should be FactusGetCreditNotesResponse`() = runTest {
        val token = "token"
        val tokenType = "tokenType"

        val response  = mockk<FactusGetCreditNotesResponse>(){
            every { data } returns mockk(){
                every { creditNotes } returns listOf(mockk())
            }
        }

        coEvery { factusCommonClient.factusTransversalsApi(token, tokenType).getCreditNotes() } returns Response.success(response)

        val result = factusTransversalsService.getCreditNotes(token, tokenType)

        coVerify {
            factusCommonClient.factusTransversalsApi(eq(token), eq(tokenType)).getCreditNotes()
        }

        assert(result.isSuccess)
        assert(result.getOrNull() == response)
    }

    @Test
    fun `GIVEN getCreditNotes WHEN getCreditNotes is Failure THEN should be FactusGetCreditNotesResponse`() = runTest {
        val token = "token"
        val tokenType = "tokenType"

        coEvery { factusCommonClient.factusTransversalsApi(token, tokenType).getCreditNotes() } returns Response.error(401, mockk(relaxed = true))

        val result = factusTransversalsService.getCreditNotes(token, tokenType)

        coVerify {
            factusCommonClient.factusTransversalsApi(eq(token), eq(tokenType)).getCreditNotes()
        }

        assert(result.isFailure)


    }




}