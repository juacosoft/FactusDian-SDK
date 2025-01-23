package com.martinezdev.factusdian.sdk.utils

import com.martinezdev.factusdian.sdk.network.api.exceptions.FactusException
import retrofit2.Response

internal class ApiCallHandler {

    inline fun <T> safeApiCall(
        call: () -> Response<T>,
        handleError: (Response<T>) -> Result<T>
    ): Result<T> {
        return try {
            val response = call()
            handleError(response)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(FactusException.Unknown(e.message))
        }
    }

    inline fun <reified T> getResponse(response: Response<T>): Result<T> {
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.success(it)
            } ?: run {
                Result.failure(FactusException.ServerError("Server Error"))
            }
        } else {
            when (response.code()) {
                401 -> Result.failure(FactusException.UnAuthorize(response.message()))
                409 -> Result.failure(FactusException.Conflict(response.message()))
                422 -> Result.failure(FactusException.IncopleteInfo(response.message()))
                else -> Result.failure(FactusException.Unknown())
            }
        }
    }
}
