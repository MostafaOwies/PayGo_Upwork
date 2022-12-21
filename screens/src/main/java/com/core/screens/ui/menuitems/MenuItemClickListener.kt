package com.core.screens.ui.menuitems

import com.core.domain.entities.Product

interface MenuItemClickListener {
    fun onItemClicked(itemId: Int, product: Product)
}