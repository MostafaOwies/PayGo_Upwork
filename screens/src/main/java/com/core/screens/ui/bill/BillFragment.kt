package com.core.screens.ui.bill

import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.core.base.BaseFragment
import com.core.screens.R
import com.core.screens.databinding.FragmentBillBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BillFragment : BaseFragment<FragmentBillBinding, BillViewModel>(), IBillFragment {

    override val viewModel: BillViewModel by viewModels()

    override fun layoutId(): Int = R.layout.fragment_bill

    override fun init() {
        val integrationType = resources.getStringArray(R.array.integration_type)
        val arrayAdapter =
            ArrayAdapter(requireContext(), R.layout.integration_type_menu_item, integrationType)
        binding.paymentMethodsContent.spIntegrationType.setAdapter(arrayAdapter)

        super.init()
    }

    override fun initListeners() {

    }

    override fun initObservers() {

    }
}