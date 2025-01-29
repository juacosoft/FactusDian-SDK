package com.martinezdev.factusdian.network

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.martinezdev.factusdian.sdk.models.AuthResponseModel
import com.martinezdev.factusdian.sdk.network.AuthService
import com.martinezdev.factusdian.sdk.services.AuthClient
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
class AuhtServiceTest {

    @MockK
    private lateinit var authClient: AuthClient

    @MockK
    private lateinit var apiCallHandler: ApiCallHandler

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var authService: AuthService

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(StandardTestDispatcher())
        authService = AuthService(
            baseUrl = "http://localhost:8080",
            clientId = "clientId",
            clientSecret = "clientSecret",
            isDebugMode = true,
            authClient = authClient,
            apiCallHandler = apiCallHandler
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `GIVEN getAuthToken WHEN getAuthToken is Success THEN should be AuthResponseModel`() = runTest {
        val user = "user"
        val pass = "pass"
        val response = mockk<AuthResponseModel>()
        coEvery { authClient.fatusAuthApi.getAuthToken(
            clientId = "clientId",
            clientSecret = "clientSecret",
            username = user,
            password = pass,
            grantType = any()
        ) } returns Response.success(response)

        val result = authService.getAuthToken(user, pass)

        coVerify { authClient.fatusAuthApi.getAuthToken(
            any(),
            withArg {
                assert(it == "clientId")
            },
            withArg {
                assert(it == "clientSecret")
            },
            withArg {
                assert(it == user)
            },
            withArg {
                assert(it == pass)
            },
        ) }

        assert(result.isSuccess)
    }

    @Test
    fun `GIVEN getAuthToken WHEN getAuthToken is Failure THEN should be Exception`() = runTest {
        coEvery { authClient.fatusAuthApi.getAuthToken(
            clientId = any(String::class),
            clientSecret = any(String::class),
            username = any(String::class),
            password = any(String::class),
            grantType = any(String::class)
        ) } returns Response.error(401, mockk(relaxed = true))

        val result = authService.getAuthToken("user", "pass")

        assert(result.isFailure)
    }

    @Test
    fun `GIVEN refreshToken WHEN refreshToken is Success THEN should be AuthResponseModel`() = runTest {
        val refreshtoken = "refreshToken"
        val response = mockk<AuthResponseModel>()
        coEvery { authClient.fatusAuthApi.refreshToken(
            clientId = "clientId",
            clientSecret = "clientSecret",
            refreshToken = refreshtoken,
            grantType = any(),
        ) } returns Response.success(response)

        val result = authService.refreshToken(refreshtoken)

        coVerify { authClient.fatusAuthApi.refreshToken(
            any(),
            withArg {
                assert(it == "clientId")
            },
            withArg {
                assert(it == "clientSecret")
            },
            withArg {
                assert(it == refreshtoken)
            }
        ) }

        assert(result.isSuccess)
    }

    @Test
    fun `GIVEN refreshToken WHEN refreshToken is Failure THEN should be Exception`() = runTest {
        coEvery { authClient.fatusAuthApi.refreshToken(
            clientId = any(String::class),
            clientSecret = any(String::class),
            refreshToken = any(String::class),
            grantType = any(String::class)
        ) } returns Response.error(401, mockk(relaxed = true))

        val result = authService.refreshToken("refreshToken")

        assert(result.isFailure)
    }
}