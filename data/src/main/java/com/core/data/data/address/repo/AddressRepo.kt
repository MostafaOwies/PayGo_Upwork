package com.core.data.data.address.repo

import com.core.domain.entities.Address
import com.core.domain.relations.onetomany.AddressWithRetailer
import kotlinx.coroutines.flow.Flow

interface AddressRepo {

    suspend fun insertAddress(address: Address)
    suspend fun deleteAddress(address: Address)
    fun getAllAddress(): Flow<List<Address>>
    fun getAddressWithRetailer(addressId: Int): Flow<List<AddressWithRetailer>>
}
