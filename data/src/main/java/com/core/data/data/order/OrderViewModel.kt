package com.core.data.data.order

import com.core.base.BaseViewModel
import com.core.data.data.MyMockData
import com.core.data.data.booking.repo.BookingRepo
import com.core.data.data.order.repo.OrderRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(val orderRepo: OrderRepo):BaseViewModel(){

}