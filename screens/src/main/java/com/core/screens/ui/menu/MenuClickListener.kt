package com.core.screens.ui.menu

import com.core.domain.entities.category.Category

interface MenuClickListener {
    fun onItemClicked(itemId: Int, category: Category)
}