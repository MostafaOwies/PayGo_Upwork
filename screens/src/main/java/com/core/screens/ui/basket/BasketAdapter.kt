package com.core.screens.ui.basket

import android.text.InputFilter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.core.base.BaseRecyclerAdapter
import com.core.domain.entities.OrderProduct
import com.core.screens.databinding.ItemBasketBinding
import com.core.utils.DecimalDigitsInputFilter

class BasketAdapter(basketCL: BasketClickListener) : BaseRecyclerAdapter<OrderProduct>() {
    private val basketClickListener = basketCL

    override fun getViewHolder(
        inflater: LayoutInflater, parent: ViewGroup, viewType: Int
    ): RecyclerView.ViewHolder {
        return BasketViewHolder(
            ItemBasketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    inner class BasketViewHolder(
        private val binding: ItemBasketBinding,
    ) : RecyclerView.ViewHolder(binding.root), Binder<OrderProduct> {

        override fun bind(item: OrderProduct) {
            val inputFilter = arrayOf<InputFilter>(DecimalDigitsInputFilter(5, 2))

            item.total=item.qty*item.price
            binding.basketItemTotalPrice.text = item.total.toString()
            binding.basketItemTotalPrice.setFilters(inputFilter)
            binding.itemObj = item
            binding.clickListener = basketClickListener
            binding.qtyLayout.qty.text = item.qty.toString()
            binding.qtyLayout.qty.text = item.qty.toString()
            bindItem(item)
            binding.executePendingBindings()
        }

        private fun bindItem(item: OrderProduct) {
            binding.apply {
                qtyLayout.let { qtyLayout ->

                    qtyLayout.addQty.setOnClickListener {
                        basketClickListener.onIncreaseQty(item.orderProductId)
                        //item.qty++

                    }

                    qtyLayout.subtractQty.setOnClickListener {
                        basketClickListener.onDecreaseQty(item.orderProductId)

                       /* if (item.qty > 1) {
                            item.qty--

                        }*/
                    }
                }
            }
        }
    }
}