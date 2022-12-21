package com.core.network

import com.core.network.interceptor.AuthHeaderInterceptor
import com.core.utils.constants.Network
import com.core.utils.constants.Network.BASE_URL
import com.core.utils.constants.Network.NAMED_CACHE_DIR
import com.core.utils.constants.Network.REQUEST_TIMEOUT_MILLISEC
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Named(NAMED_DEFAULT_OKHTTP_CLIENT_BUILDER)
    fun provideDefaultOkHttpClientBuilder(
        loggingInterceptor: HttpLoggingInterceptor,
        authHeaderInterceptor: AuthHeaderInterceptor,
        cache: Cache
    ): OkHttpClient.Builder = OkHttpClient.Builder()
        .addInterceptor(authHeaderInterceptor)
        .addInterceptor(loggingInterceptor)
        .connectTimeout(REQUEST_TIMEOUT_MILLISEC, TimeUnit.MILLISECONDS)
        .readTimeout(REQUEST_TIMEOUT_MILLISEC, TimeUnit.MILLISECONDS)
        .writeTimeout(REQUEST_TIMEOUT_MILLISEC, TimeUnit.MILLISECONDS)
        .cache(cache)

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @Named(NAMED_DEFAULT_OKHTTP_CLIENT_BUILDER) okHttpClientBuilder: OkHttpClient.Builder
    ): OkHttpClient {
        return okHttpClientBuilder
            .build()
    }

    @Provides
    @Singleton
    fun provideCache(
        @Named(NAMED_CACHE_DIR) cacheDir: File
    ): Cache {
        val httpCacheDir = File(cacheDir, Network.HTTP)
        val httpCacheSize: Long = Network.HTTP_CACHE.toLong()
        return Cache(httpCacheDir, httpCacheSize)
    }

    @Provides
    fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return logging
    }
}

const val NAMED_DEFAULT_OKHTTP_CLIENT_BUILDER = "okhttp_client_builder"
