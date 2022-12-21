package com.core.screens.ui.menuitemdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.core.base.BaseViewModel
import com.core.data.data.product.repo.ProductRepo
import com.core.domain.entities.Favorites
import com.core.domain.entities.OrderProduct
import com.core.domain.entities.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuItemDetailsViewModel
@Inject constructor(
    private val productRepo: ProductRepo
) : BaseViewModel() {

    private val _product = MutableStateFlow<Product>(Product())
    val product: StateFlow<Product> = _product
    var counter: MutableLiveData<Int> = MutableLiveData<Int>()

    fun setCounter(count: Int) {
        this.counter.value = count
    }

    fun getProductById(productId: Int) = productRepo.getProductWithId(productId)

    fun getProducts(): StateFlow<Product> = product

    fun saveToFavorites(favorites: Favorites) = viewModelScope.launch {
        productRepo.insertFavorite(favorites)
    }

    fun getFavorites() = productRepo.getAllFavorites()

    fun saveToOrderProduct(orderProduct: OrderProduct) = viewModelScope.launch {
        productRepo.insertOrderProduct(orderProduct)
    }
}