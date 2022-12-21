package com.core.network.interceptor

import com.core.preference.SharedPreferenceHelper
import com.core.utils.constants.SharedPreferenceKeys
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthHeaderInterceptor @Inject constructor(private val sharedPreferenceHelper: SharedPreferenceHelper) :
    Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val shouldAddAuthHeaders = original.headers["isAuthorizable"] != "false"

        val requestBuilder = original
            .newBuilder()
            .method(original.method, original.body)
            .removeHeader("isAuthorizable")

        if (shouldAddAuthHeaders) {

            val token = sharedPreferenceHelper[SharedPreferenceKeys.ACCESS_TOKEN, ""]
            // it fails after this line
            requestBuilder.header("Authorization", "Bearer $token")
        }
        return chain.proceed(requestBuilder.build())

    }

}