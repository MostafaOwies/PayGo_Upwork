package com.core.screens.ui.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.core.base.BaseRecyclerFilterAdapter
import com.core.domain.entities.category.Category
import com.core.screens.databinding.ItemCateBinding


class MenuAdapter(menuCL: MenuClickListener) : BaseRecyclerFilterAdapter<Category>() {

    private val menuClickListener = menuCL

    init {
        filteredList = getNamesListFromObjectList(items.currentList)
    }

    fun getNamesListFromObjectList(list: List<Category>): ArrayList<String> {
        return list.map { it.name } as ArrayList<String>
    }

    override fun getViewHolder(
        inflater: LayoutInflater, parent: ViewGroup, viewType: Int
    ): RecyclerView.ViewHolder {
        return MenuItemViewHolder(
            ItemCateBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    inner class MenuItemViewHolder(
        private val binding: ItemCateBinding,
    ) : RecyclerView.ViewHolder(binding.root), Binder<Category> {

        override fun bind(item: Category) {
            binding.itemObj = item
            binding.clickListener = menuClickListener
            bindItem(item)
            binding.executePendingBindings()
        }

        private fun bindItem(item: Category) {

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
                    val newList = ArrayList<Category>()
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
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}