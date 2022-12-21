package com.core.screens.ui.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.core.base.BaseRecyclerAdapter
import com.core.domain.entities.Favorites
import com.core.screens.databinding.ItemFavouriteBinding

class FavouritesAdapter(favouriteCL: FavouriteClickListener) :
    BaseRecyclerAdapter<Favorites>() {
    private val favouriteClickListener = favouriteCL

    override fun getViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return FavouritesViewHolder(
            ItemFavouriteBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    inner class FavouritesViewHolder(
        private val binding: ItemFavouriteBinding,
    ) : RecyclerView.ViewHolder(binding.root), Binder<Favorites> {

        override fun bind(item: Favorites) {
            binding.itemObj = item
            binding.clickListener = favouriteClickListener
            bindItem(item)
            binding.executePendingBindings()
        }

        private fun bindItem(item: Favorites) {

        }
    }
}