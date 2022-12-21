package com.core.data.data.address.repo

import com.core.data.data.address.dao.AddressDao
import com.core.domain.entities.Address
import com.core.domain.relations.onetomany.AddressWithRetailer
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddressRepoImp @Inject constructor(private val addressDao: AddressDao) : AddressRepo {

    override suspend fun insertAddress(address: Address) {
        addressDao.insertAddress(address)
    }

    override suspend fun deleteAddress(address: Address) {
        addressDao.deleteAddress(address)
    }

    override fun getAllAddress(): Flow<List<Address>> {
        return addressDao.getAll()
    }

    override fun getAddressWithRetailer(addressId: Int): Flow<List<AddressWithRetailer>> {
        return addressDao.getAddressWithRetailer(addressId)
    }

}
