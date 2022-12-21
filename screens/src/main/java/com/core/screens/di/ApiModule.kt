package com.core.screens.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
//    @Provides
//    @Singleton
//    fun provideLoginApi(retrofit: Retrofit): LoginApi = retrofit.create()
//
//    @Provides
//    @Singleton
//    fun provideLoginRepository(
//        @ApplicationContext context: Context,
//        networkHandler: NetworkHandler,
//        loginApi: LoginApi
//    ): LoginRemoteDataSource {
//        return LoginRemoteDataSource.LoginRemoteDataSourceImpl(
//            networkHandler,
//            loginApi
//        )
//    }
}