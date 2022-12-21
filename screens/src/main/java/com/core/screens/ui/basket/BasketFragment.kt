package com.core.screens.ui.basket

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.core.base.BaseFragment
import com.core.screens.Navigation
import com.core.screens.R
import com.core.screens.databinding.FragmentBasketBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class BasketFragment : BaseFragment<FragmentBasketBinding, BasketViewModel>(),
    IBasketFragment, BasketClickListener {

    private lateinit var myAdapter: BasketAdapter

   /* private val textList = arrayListOf(
        MockItem(1, "test1", 1),
        MockItem(2, "test2", 1),
        MockItem(3, "test3", 1),
        MockItem(4, "test4", 1),
        MockItem(5, "test5", 1),
        MockItem(6, "test6", 1),
        MockItem(7, "test7", 1),
        MockItem(8, "test8", 1),
        MockItem(9, "test9", 1),
        MockItem(10, "test10", 1),
    )*/

    override val viewModel: BasketViewModel by viewModels()

    override fun layoutId(): Int = R.layout.fragment_basket

    override fun init() {
        setupRecyclerView()

       /* lifecycleScope.launch {
            viewModel.getOrders().collect {
                for (order in it){
                    viewModel.deleteOrder(order)
                }
            }
        }*/

        binding.checkoutBtn.setOnClickListener {
             initViews()
        }

        super.init()
    }

    override fun initListeners() {

    }

    override fun initObservers() {

    }

    fun initViews() {
        try {
            lifecycleScope.launch {
                viewModel.getOrders().collect{
                    viewModel.updateOrderInFireStore(it)
                }
            }
        }catch (e :Exception) {
            e.printStackTrace()
        }
    }

    override fun onIncreaseQty(itemId: Int) {
        var qtyCount = viewModel.getOrderProducts().value.qty
        qtyCount = qtyCount.plus(1)
        viewModel.setCounter(qtyCount)
        viewModel.getOrderProducts().value.qty = qtyCount
       // binding..qtyLayout.qty.text = qtyCount.toString()
    }

    override fun onDecreaseQty(itemId: Int) {
        if (viewModel.getOrderProducts().value.qty > 1) {
            var qtyCount = viewModel.getOrderProducts().value.qty
            qtyCount = qtyCount.minus(1)
            viewModel.getOrderProducts().value.qty = qtyCount
           // binding.favButtonBar.qtyLayout.qty.text = qtyCount.toString()
        }
    }

    override fun setupRecyclerView() {
        myAdapter = BasketAdapter(this)
        binding.basketItemTv.adapter = myAdapter

        lifecycleScope.launch {
            viewModel.getOrders().collect {
                myAdapter.submitList(it)
            }
        }
    }

    override fun onItemClicked(itemId: Int) {
        Navigation.navToMenuItemsDetailsFragmentFromBasket(findNavController())
    }

    override fun onDeleteItemClicked(itemId: Int) {

    }
}