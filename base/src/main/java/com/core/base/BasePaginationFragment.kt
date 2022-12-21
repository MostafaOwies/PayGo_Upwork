package com.core.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


abstract class BasePaginationFragment<BINDING : ViewDataBinding, VM : BaseViewModel> :
    BaseFragment<BINDING, VM>() {

    private val recyclerView: RecyclerView
        get() = recyclerView()

    abstract fun recyclerView(): RecyclerView

    abstract fun onScrollEnd()

    override fun init() {
        recyclerView.addOnScrollListener(scrollListener())
    }

    private fun scrollListener(): RecyclerView.OnScrollListener {
        return object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager?
                    val visibleItemCount = layoutManager?.childCount ?: 0
                    val totalItemCount = layoutManager?.itemCount ?: 0
                    val pastVisibleItems =
                        layoutManager?.findFirstCompletelyVisibleItemPosition() ?: 0
                    if (pastVisibleItems + visibleItemCount >= totalItemCount) {
                        onScrollEnd()
                    }
                }
            }
        }
    }
}