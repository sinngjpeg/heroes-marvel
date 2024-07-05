package br.com.jpegsinng.core.data.network.intercerptor

import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest
import java.util.Calendar

class AuthorizationInterceptor(
    private val publicKey: String,
    private val privateKey: String,
    private val calendar: Calendar,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestUrl = request.url
        val ts = (calendar.timeInMillis / 1000L).toString()
        val hash = "$ts$privateKey$publicKey".md5()
        val finalUrl = requestUrl.newBuilder()
            .addQueryParameter(QUERY_PARAM_TS, ts)
            .addQueryParameter(QUERY_PARAM_API_KEY, publicKey)
            .addQueryParameter(QUERY_PARAM_HASH, hash)
            .build()

        return chain.proceed(
            request.newBuilder()
                .url(finalUrl)
                .build()
        )
    }

    private fun String.md5(): String{
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }

    companion object {
        private const val QUERY_PARAM_TS = "ts"
        private const val QUERY_PARAM_API_KEY = "apikey"
        private const val QUERY_PARAM_HASH = "hash"
    }
}
