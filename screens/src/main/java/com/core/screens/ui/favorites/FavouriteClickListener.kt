package com.core.screens.ui.favorites

import com.core.domain.entities.Favorites

interface FavouriteClickListener {
    fun onItemClicked(itemId: Int, favorites: Favorites)
    fun onDeleteItemClicked(itemId: Int)
}