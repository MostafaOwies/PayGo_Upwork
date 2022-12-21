package com.core.screens.ui.basket

interface BasketClickListener {
    fun onItemClicked(itemId: Int)
    fun onIncreaseQty(itemId: Int)
    fun onDecreaseQty(itemId: Int)
    fun onDeleteItemClicked(itemId: Int)
}