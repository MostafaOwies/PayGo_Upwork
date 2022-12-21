package com.core.data.data.product.dao

import androidx.room.*
import com.core.domain.entities.Favorites
import com.core.domain.entities.OrderProduct
import com.core.domain.entities.Product
import com.core.domain.relations.onetomany.ProductWithSubProductType
import com.core.domain.relations.onetoone.ProductAndOrderProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(vararg product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(vararg favorites: Favorites)

    @Delete
    suspend fun deleteFavorites(favorites: Favorites)

    @Insert
    suspend fun insertOrderProduct(vararg orderProduct: OrderProduct)

    @Query("SELECT * FROM Favorites")
    fun getAllFavorites(): Flow<List<Favorites>>

    @Query("SELECT * FROM Product")
    fun getAllProducts(): Flow<List<Product>>

    @Query("SELECT * FROM Product")
    fun getProduct(): Flow<Product>

    @Transaction
    @Query("SELECT * FROM Product WHERE ProductId = :productId")
    fun getProductAndOrderProductWithProductId(productId: Int): Flow<List<ProductAndOrderProduct>>

    @Transaction
    @Query("SELECT * FROM Product WHERE ProductId = :productId")
    fun getProductWithSubProductType(productId: Int): Flow<List<ProductWithSubProductType>>

    @Transaction
    @Query("SELECT * FROM Product WHERE categoryId= :categoryId")
    fun getProductsOfCategory(categoryId: Int): Flow<List<Product>>

    @Query("SELECT * FROM Product WHERE ProductId = :productId")
    fun getProductWithId(productId: Int): Flow<Product>


}