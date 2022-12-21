package com.core.screens.ui.menuitemdetails

interface IMenuItemDetailsFragment {
    suspend fun initViews()
    fun increaseQuantity()
    fun decreaseQuantity()
    fun addToFavorites()
    suspend fun checkFavorite()
    fun addToBasket()
}
