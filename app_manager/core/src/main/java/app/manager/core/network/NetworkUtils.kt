package app.manager.core.network

import android.annotation.SuppressLint
import okhttp3.CipherSuite
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*

object NetworkUtils {

    fun getOkHttpSpecs(okHttpClient: OkHttpClient.Builder): OkHttpClient.Builder? {
        return okHttpClient.connectionSpecs(getConnectionSpec())
    }

    fun getUnsafeOkHttp(okHttpClient: OkHttpClient.Builder): OkHttpClient.Builder? {
        val x509TrustManager = getUnsafeX509TrustManager()
        return okHttpClient
            .sslSocketFactory(getSocketFactory(x509TrustManager), x509TrustManager)
            .hostnameVerifier(getHostnameVerifier())
    }

    private fun getConnectionSpec(): List<ConnectionSpec> {
        val spec = ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
            .tlsVersions(TlsVersion.TLS_1_2)
            .cipherSuites(
                CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 // <-- Worked with 7.0
            )
            .build()
        return listOf(spec)
    }

    /*
    * Off certificate check
    * */
    private fun getSocketFactory(trustManager: X509TrustManager): SSLSocketFactory {
        try {
            // Create a trust manager that does not validate certificate chains
            val trustAllCerts = arrayOf<TrustManager>(trustManager)
            // Install the all-trusting trust manager
            val sslContext = SSLContext.getInstance("TLS")
            sslContext.init(null, trustAllCerts, SecureRandom())
            // Create an ssl socket factory with our all-trusting manager
            return sslContext.socketFactory
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    private fun getUnsafeX509TrustManager(): X509TrustManager {
        return object : X509TrustManager {
            @SuppressLint("TrustAllX509TrustManager")
            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
            }

            @SuppressLint("TrustAllX509TrustManager")
            override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
            }

            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return arrayOf()
            }
        }
    }

    private fun getHostnameVerifier(): HostnameVerifier {
        return HostnameVerifier { _: String?, _: SSLSession? -> true }
    }

}