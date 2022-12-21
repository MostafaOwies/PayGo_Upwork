package com.core.data.data.product.repo

import com.core.data.data.product.dao.ProductDao
import com.core.domain.entities.Favorites
import com.core.domain.entities.OrderProduct
import com.core.domain.entities.Product
import com.core.domain.relations.onetomany.ProductWithSubProductType
import com.core.domain.relations.onetoone.ProductAndOrderProduct
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepoImp @Inject constructor(private val productDao: ProductDao) : ProductRepo {

    override suspend fun insertProduct(product: Product) {
        productDao.insertProduct(product)
    }

    override suspend fun deleteProduct(product: Product) {
        productDao.deleteProduct(product)
    }

    override fun getAllProducts(): Flow<List<Product>> {
        return productDao.getAllProducts()
    }

    override fun getProduct(): Flow<Product> {
        return productDao.getProduct()
    }

    override fun getProductAndOrderProductWithProductId(productId: Int): Flow<List<ProductAndOrderProduct>> {
        return productDao.getProductAndOrderProductWithProductId(productId)
    }

    override fun getProductWithSubProductType(productId: Int): Flow<List<ProductWithSubProductType>> {
        return productDao.getProductWithSubProductType(productId)
    }

    override fun getProductsOfCategory(categoryId: Int): Flow<List<Product>> {
        return productDao.getProductsOfCategory(categoryId)
    }

    override fun getProductWithId(productId: Int): Flow<Product> {
        return productDao.getProductWithId(productId)
    }

    override suspend fun insertFavorite(favorites: Favorites) {
        productDao.insertFavorite(favorites)
    }

    override suspend fun deleteFavorites(favorites: Favorites) {
        productDao.deleteFavorites(favorites)
    }

    override fun getAllFavorites(): Flow<List<Favorites>> {
        return productDao.getAllFavorites()
    }

    override suspend fun insertOrderProduct(orderProduct: OrderProduct) {
         productDao.insertOrderProduct(orderProduct)
    }
}