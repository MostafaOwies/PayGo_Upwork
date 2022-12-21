package com.core.screens.ui.favorites

import com.core.base.BaseViewModel
import com.core.data.data.favorites.repo.FavoritesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel
@Inject constructor(
private val favoritesRepo: FavoritesRepo
) : BaseViewModel() {

    fun getFavorites () = favoritesRepo.getAllFavorites()
}