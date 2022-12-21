package com.core.screens.ui.transaction

import androidx.fragment.app.viewModels
import com.core.base.BaseFragment
import com.core.base.oldbase.MockItem
import com.core.screens.R
import com.core.screens.databinding.FragmentTransactionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionFragment : BaseFragment<FragmentTransactionBinding, TransactionViewModel>() {

    private lateinit var myAdapter: TransactionAdapter

    private val textList = arrayListOf(
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
    )

    override val viewModel: TransactionViewModel by viewModels()

    override fun layoutId(): Int = R.layout.fragment_transaction

    override fun init() {
        setupRecyclerView()

        super.init()
    }

    override fun initListeners() {

    }

    override fun initObservers() {

    }

    private fun setupRecyclerView() {
        myAdapter = TransactionAdapter()
        binding.transactionsRv.adapter = myAdapter
        myAdapter.submitList(textList)
    }
}