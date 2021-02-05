package app.manager.core.network.interceptors

import app.manager.core.network.Api
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import kotlin.jvm.Throws

class BaseInterceptor : Interceptor {

    companion object {
        private const val KEY_AUTH = "Bearer "
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        request = request.newBuilder().header(
            Api.HEADER_AUTHORIZATION, KEY_AUTH + request.header(Api.HEADER_AUTHORIZATION)
        ).build()

        return chain.proceed(request)
    }


}