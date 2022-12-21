package com.core.screens.ui.menuitems

import androidx.lifecycle.viewModelScope
import com.core.base.BaseViewModel
import com.core.data.data.product.repo.ProductRepo
import com.core.domain.entities.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuItemsViewModel
@Inject constructor(
    private val productRepo: ProductRepo
) : BaseViewModel() {


    // val menuListFlow : Flow<List<Product>> = productRepo.getAllProducts()


    fun saveProducts(product: Product) = viewModelScope.launch {
        productRepo.insertProduct(product)
    }

    fun getProductList(categoryId: Int) = productRepo.getProductsOfCategory(categoryId)

    /*fun saveToFavorites(favorites: Favorites) = viewModelScope.launch {
        productRepo.insertFavorite(favorites)
    }*/

    //fun getFavorites() = productRepo.getAllFavorites()
}