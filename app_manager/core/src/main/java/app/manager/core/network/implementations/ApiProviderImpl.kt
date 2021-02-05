package app.manager.core.network.implementations

import app.manager.core.network.Api
import app.manager.core.network.ApiProvider
import app.manager.core.network.ApiResponse
import app.manager.core.network.models.request.RequestSignIn
import retrofit2.HttpException

class ApiProviderImpl(private val api: Api, private val token: String?) : ApiProvider {

    override suspend fun capability(): ApiResponse = call { api.capabilities() }

    override suspend fun getUserInfo(): ApiResponse = call { api.getUserInfo(token) }

    override suspend fun signIn(request: RequestSignIn): ApiResponse {
        return call { api.signIn(request) }
    }

    private suspend inline fun <T> call(crossinline block: suspend () -> T): ApiResponse {
        return try {
            ApiResponse.Success(block.invoke() ?: Any())
        } catch (error: Exception) {
            catchError(error)
        }
    }

    private fun catchError(exception: Exception): ApiResponse {
        return when (exception) {
            is HttpException -> {
                exception.response()?.let {
                    ApiResponse.HttpError(HttpException(it))
                } ?: ApiResponse.HttpError(exception)
            }
            else -> {
                ApiResponse.Error(exception)
            }

        }
    }

}