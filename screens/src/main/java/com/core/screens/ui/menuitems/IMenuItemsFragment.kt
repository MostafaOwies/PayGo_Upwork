package com.core.screens.ui.menuitems

interface IMenuItemsFragment {
    fun saveProducts()
    fun setUpSearchView()
    suspend fun initRecyclerView()
}
