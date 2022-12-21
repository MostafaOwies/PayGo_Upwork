package com.core.screens.ui.menuitems

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.core.base.BaseRecyclerFilterAdapter
import com.core.domain.entities.Product
import com.core.screens.R
import com.core.screens.databinding.ItemMenuItemsBinding

class MenuItemsAdapter(menuItemCL: MenuItemClickListener, favClick: AddToFavorites) :
    BaseRecyclerFilterAdapter<Product>() {

    private val menuItemClickListener = menuItemCL
    private val favoritesItemClickListener = favClick

    init {
        filteredList = getNamesListFromObjectList(items.currentList)
    }

    fun getNamesListFromObjectList(list: List<Product>): ArrayList<String> {
        return list.map { it.name } as ArrayList<String>
    }

    override fun getViewHolder(
        inflater: LayoutInflater, parent: ViewGroup, viewType: Int
    ): RecyclerView.ViewHolder {
        return MenuItemsItemViewHolder(
            ItemMenuItemsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    inner class MenuItemsItemViewHolder(
        private val binding: ItemMenuItemsBinding,
    ) : RecyclerView.ViewHolder(binding.root), Binder<Product> {

        override fun bind(item: Product) {
            binding.itemObj = item
            binding.clickListener = menuItemClickListener
            bindItem(item)
            binding.executePendingBindings()
        }

        private fun bindItem(item: Product) {

            binding.favClickListener = favoritesItemClickListener
            binding.isFavoriteImgView.setOnClickListener {
                favoritesItemClickListener
                if (item.isFavorite) {
                    binding.isFavoriteImgView.setImageResource(R.drawable.fav_selected)
                } else {
                    binding.isFavoriteImgView.setImageResource(R.drawable.fav_not_selected)
                }
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                filteredList = if (charSearch.isEmpty()) {
                    getNamesListFromObjectList(mainList)
                } else {
                    val resultList = ArrayList<String>()
                    for (row in getNamesListFromObjectList(mainList)) {
                        if (row.lowercase().contains(charSearch.lowercase())) {
                            resultList.add(row)
                        }
                    }
                    resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filteredList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                try {
                    val newList = ArrayList<Product>()
                    filteredList = results?.values as ArrayList<String>
                    mainList.forEach { item ->
                        filteredList.forEachIndexed { index, filtered ->
                            if (item.name.equals(filtered, true)) {
                                newList.add(item)
                                return@forEachIndexed
                            }
                        }
                    }
                    submitList(newList)
                    notifyDataSetChanged()
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}