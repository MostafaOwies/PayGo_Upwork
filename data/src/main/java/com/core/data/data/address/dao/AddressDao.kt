package com.core.data.data.address.dao

import androidx.room.*
import com.core.domain.entities.Address
import com.core.domain.relations.onetomany.AddressWithRetailer
import kotlinx.coroutines.flow.Flow

@Dao
interface AddressDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAddress(vararg address: Address)

    @Delete
    suspend fun deleteAddress(address: Address)

    @Query("SELECT * FROM Address")
    fun getAll(): Flow<List<Address>>

    @Transaction
    @Query("SELECT * FROM Address WHERE addressId = :addressId")
    fun getAddressWithRetailer(addressId: Int): Flow<List<AddressWithRetailer>>

}