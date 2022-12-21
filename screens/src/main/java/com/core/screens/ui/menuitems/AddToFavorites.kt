package com.core.screens.ui.menuitems

import com.core.domain.entities.Product

interface AddToFavorites {
    fun onFavoritesClicked(itemId: Int, product: Product)

}