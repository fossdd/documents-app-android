
package app.manager.core.di.module

import app.manager.core.network.Api
import app.manager.core.network.NetworkUtils
import app.manager.core.network.interceptors.BaseInterceptor
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import lib.toolkit.base.managers.utils.TimeUtils
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class RetrofitModule(val url: String, val isSslOn: Boolean = false, val isCipher: Boolean = false) {

    private val READ_TIMEOUT = 60
    private val WRITE_TIMEOUT = 60
    private val CONNECT_TIMEOUT = 60

    @Provides
    fun provideUrl(): String {
        return url
    }

    @Provides
    fun provideIsSslOn(): Boolean {
        return isSslOn
    }

    @Provides
    fun providesIsCipher(): Boolean {
        return isCipher
    }

    @Provides
//    @UrlScope
    fun provideOkHttpClient(): OkHttpClient {
        val builder = getOkHttp()
        if (!isSslOn) {
            NetworkUtils.getUnsafeOkHttp(builder)
        }
        if (isCipher) {
            NetworkUtils.getOkHttpSpecs(builder)
        }
        return builder.build()
    }

    @Provides
//    @UrlScope
    fun getGsonConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create(
            GsonBuilder()
                .setLenient()
                .setPrettyPrinting()
                .setDateFormat(TimeUtils.OUTPUT_PATTERN_DEFAULT)
                .serializeNulls()
                .create()
        )
    }

    @Provides
//    @UrlScope
    fun provideRetrofit(url: String, factory: Converter.Factory, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url).addConverterFactory(factory)
            .client(client)
            .build()
    }

    @Provides
    fun getApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    private fun getOkHttp(): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder()
        return builder.protocols(listOf(Protocol.HTTP_1_1))
            .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .addInterceptor(BaseInterceptor())
    }

}