package com.core.data.data.address.di

import com.core.data.PayGoDatabase
import com.core.data.data.address.dao.AddressDao
import com.core.data.data.address.repo.AddressRepo
import com.core.data.data.address.repo.AddressRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AddressModule {

    @Provides
    @Singleton
    fun provideAddressDao(db: PayGoDatabase): AddressDao {
        return db.getAddressDao()
    }

    @Provides
    @Singleton
    fun provideAddressRepo(addressRepoImp: AddressRepoImp): AddressRepo {
        return addressRepoImp
    }
}