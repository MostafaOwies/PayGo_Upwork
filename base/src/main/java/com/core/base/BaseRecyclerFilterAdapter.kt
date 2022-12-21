package com.core.base


import android.widget.Filterable


abstract class BaseRecyclerFilterAdapter<T> : BaseRecyclerAdapter<T>(), Filterable {

    var filteredList = ArrayList<String>()

    lateinit var mainList: List<T>

    fun submitFilterList(mNewList: List<T>) {
        mainList = mNewList
        items.submitList(mNewList)
    }
}