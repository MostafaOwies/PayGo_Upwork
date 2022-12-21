package com.core.data.data.product.repo

import com.core.domain.entities.Favorites
import com.core.domain.entities.OrderProduct
import com.core.domain.entities.Product
import com.core.domain.relations.onetomany.ProductWithSubProductType
import com.core.domain.relations.onetoone.ProductAndOrderProduct
import kotlinx.coroutines.flow.Flow

interface ProductRepo {

    suspend fun insertProduct(product: Product)
    suspend fun deleteProduct(product: Product)
    fun getAllProducts(): Flow<List<Product>>
    fun getProduct(): Flow<Product>
    fun getProductAndOrderProductWithProductId(productId: Int): Flow<List<ProductAndOrderProduct>>
    fun getProductWithSubProductType(productId: Int): Flow<List<ProductWithSubProductType>>
    fun getProductsOfCategory(categoryId: Int): Flow<List<Product>>
    fun getProductWithId(productId: Int): Flow<Product>
    suspend fun insertFavorite(favorites: Favorites)
    suspend fun insertOrderProduct(orderProduct: OrderProduct)
    suspend fun deleteFavorites(favorites: Favorites)
    fun getAllFavorites(): Flow<List<Favorites>>
}