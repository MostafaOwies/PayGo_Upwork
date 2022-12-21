package com.core.screens.ui.more

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.core.base.BaseFragment
import com.core.screens.Navigation
import com.core.screens.R
import com.core.screens.databinding.FragmentMoreBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoreFragment : BaseFragment<FragmentMoreBinding, MoreViewModel>() {

    override val viewModel: MoreViewModel by viewModels()

    override fun layoutId(): Int = R.layout.fragment_more

    override fun init() {
        initViews()

        super.init()
    }

    override fun initListeners() {

    }

    override fun initObservers() {

    }

    private fun initViews() {
        binding.transactionCardView.setOnClickListener {
            Navigation.navToTransactionFragment(findNavController())
        }
    }
}