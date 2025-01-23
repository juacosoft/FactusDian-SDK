package com.martinezdev.factusdian.sdk.network.api.exceptions

sealed class FactusException(message: String? = null, cause: Throwable? = null) : Exception(message, cause) {
    class Conflict(message: String? = null, cause: Throwable? = null) : FactusException(message, cause)
    class UnAuthorize(message: String? = null, cause: Throwable? = null) : FactusException(message, cause)
    class IncopleteInfo( message: String? = null) : FactusException(message)
    class ServerError(message: String? = null, cause: Throwable? = null) : FactusException(message, cause)
    class Unknown(message: String? = null, cause: Throwable? = null) : FactusException(message, cause)
}
