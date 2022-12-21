package com.core.screens.ui.basket

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.core.base.BaseViewModel
import com.core.data.data.orderproduct.repo.OrderProductRepo
import com.core.domain.entities.OrderProduct
import com.core.utils.constants.Constants
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BasketViewModel
@Inject constructor(
    private val orderProductRepo: OrderProductRepo
) : BaseViewModel() {


    val mFireStore = Firebase.firestore


    private val _orderProduct = MutableStateFlow<OrderProduct>(OrderProduct())
    val orderProduct: StateFlow<OrderProduct> = _orderProduct

    var counter: MutableLiveData<Int> = MutableLiveData<Int>()

    fun setCounter(count: Int) {
        this.counter.value = count
    }

    fun getOrderProducts(): StateFlow<OrderProduct> = orderProduct

    fun getOrders() = orderProductRepo.getAllOrderProducts()
    fun deleteOrder(orderProduct: OrderProduct) = viewModelScope.launch {
        orderProductRepo.deleteOrderProduct(orderProduct)
    }

    suspend fun updateOrderInFireStore (  ordersList :List<OrderProduct>) {
        try {
            val orderHashMap= HashMap<String,Any>()
            orderHashMap[Constants.ORDER_PRODUCT] = ordersList
            withContext(Dispatchers.IO){
                mFireStore.collection(Constants.ORDER_PRODUCT)
                    .add(orderHashMap)
                    .addOnSuccessListener {
                    }
            }
        }catch ( e:Exception) {
            e.printStackTrace()
        }
    }
}