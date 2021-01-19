package app.manager.core.network

import retrofit2.HttpException

sealed class ApiResponse {
    class Success(val response: Any) : ApiResponse()
    class HttpError(val exception: HttpException) : ApiResponse()
    class Error(val exception: Throwable) : ApiResponse()
}

inline fun <reified T> ApiProvider.getResponse(response: ApiResponse): T? {
    return if (response is ApiResponse.Success && response.response is T) {
        response.response
    } else null
}

interface ApiProvider {

    suspend fun capability(): ApiResponse

    suspend fun getUserInfo(): ApiResponse

}