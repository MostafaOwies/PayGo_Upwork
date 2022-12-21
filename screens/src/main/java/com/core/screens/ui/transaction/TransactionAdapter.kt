package com.core.screens.ui.transaction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.core.base.BaseRecyclerAdapter
import com.core.base.oldbase.MockItem
import com.core.screens.databinding.ItemTransactionBinding

class TransactionAdapter() : BaseRecyclerAdapter<MockItem>() {

    override fun getViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return TransactionViewHolder(
            ItemTransactionBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    inner class TransactionViewHolder(
        private val binding: ItemTransactionBinding,
    ) : RecyclerView.ViewHolder(binding.root), Binder<MockItem> {

        override fun bind(item: MockItem) {
            binding.itemObj = item
            bindItem(item)
            binding.executePendingBindings()
        }

        private fun bindItem(item: MockItem) {

        }
    }
}