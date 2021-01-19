package app.manager.core.network

import app.manager.core.network.factory.ConverterFactory
import app.manager.core.network.interceptors.WebDavInterceptor
import app.manager.core.network.models.explorer.WebDavModel
import lib.toolkit.base.managers.tools.RetrofitTool
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface WebDavApi {

    companion object {
        const val HEADER_AUTHORIZATION = "Authorization"
        const val HEADER_DESTINATION = "Destination"
        const val HEADER_OVERWRITE = "Overwrite"
        const val HEADER_DEPTH_0 = "Depth: 0"
        const val HEADER_DEPTH_1 = "Depth: 1"
    }

    enum class Providers(var path: String) {
        NextCloud("/remote.php/dav/files/"), OwnCloud("/remote.php/dav/files/"), Yandex("/"), WebDav("/");

    }

    fun getApi(baseUrl: String): WebDavApi {
        var baseUrl = baseUrl
        if (!baseUrl.endsWith("/")) {
            baseUrl = "$baseUrl/"
        }
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(ConverterFactory())
            .client(getClient())
            .build()
        return retrofit.create(WebDavApi::class.java)
    }

    fun getClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .readTimeout(RetrofitTool.READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(RetrofitTool.WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .connectTimeout(RetrofitTool.CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .addInterceptor(WebDavInterceptor())
            .build()
    }

    @HTTP(method = "GET")
    suspend fun capability(@Url url: String?): Call<ResponseBody>

    @ConverterFactory.Xml
    @Headers(HEADER_DEPTH_0)
    @HTTP(method = "PROPFIND")
    suspend fun capabilities(
        @Header(HEADER_AUTHORIZATION) auth: String?,
        @Url path: String?
    ): Call<ResponseBody>

    @ConverterFactory.Xml
    @Headers(HEADER_DEPTH_1)
    @HTTP(method = "PROPFIND")
    suspend fun propfind(@Url path: String): Call<WebDavModel>

    @ConverterFactory.Xml
    @HTTP(method = "MKCOL")
    suspend fun createFolder(@Url path: String): Call<ResponseBody>

    @ConverterFactory.Xml
    @HTTP(method = "DELETE")
    suspend fun delete(@Url path: String): Call<ResponseBody>

    @ConverterFactory.Xml
    @HTTP(method = "MOVE")
    suspend fun move(
        @Header(HEADER_DESTINATION) newFile: String,
        @Url oldFile: String,
        @Header(HEADER_OVERWRITE) overwrite: String
    ): Call<ResponseBody>

    @ConverterFactory.Xml
    @HTTP(method = "COPY")
    suspend fun copy(
        @Header(HEADER_DESTINATION) newFile: String,
        @Url oldFile: String,
        @Header(HEADER_OVERWRITE) overwrite: String
    ): Call<ResponseBody>

    @ConverterFactory.Xml
    @HTTP(method = "LOCK")
    suspend fun lock(@Url path: String?): Call<ResponseBody>

    @ConverterFactory.Xml
    @HTTP(method = "UNLOCK")
    suspend fun unlock(@Url path: String?): Call<ResponseBody>

    @ConverterFactory.Xml
    @PUT
    suspend fun upload(@Body body: RequestBody?, @Url name: String?): Call<ResponseBody>

    @ConverterFactory.Xml
    @Streaming
    @GET
    suspend fun download(@Url path: String?): Call<ResponseBody>

}