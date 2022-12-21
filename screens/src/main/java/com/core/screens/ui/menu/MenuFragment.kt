package com.core.screens.ui.menu

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.core.base.BaseFragment
import com.core.data.data.MyMockData
import com.core.domain.entities.category.Category
import com.core.screens.Navigation
import com.core.screens.R
import com.core.screens.databinding.FragmentMenuBinding
import com.core.utils.constants.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MenuFragment : BaseFragment<FragmentMenuBinding, MenuViewModel>(), IMenuFragment,
    MenuClickListener {

    private lateinit var myAdapter: MenuAdapter

    /* private val textList = arrayListOf(
         MockItem(1, "drink 1", 1),
         MockItem(2, "eat 1", 1),
         MockItem(3, "drink 3", 1),
         MockItem(4, "eat 3", 1),
         MockItem(5, "eat 5", 1),
         MockItem(6, "drink 5", 1),
         MockItem(7, "test 7", 1),
         MockItem(8, "test 8", 1),
         MockItem(9, "test 9", 1),
         MockItem(10, "test 10", 1),
     )*/

    override val viewModel: MenuViewModel by viewModels()

    override fun layoutId(): Int = R.layout.fragment_menu

    override fun init() {

       /* lifecycleScope.launch {
            viewModel.getCategoryList().collect {
                for (cate in it) {
                    viewModel.deleteCates(cate)
                }
            }
        }*/

        saveCategories()

        setUpSearchView()

        initRecyclerView()


        super.init()
    }

    override fun initListeners() {

    }

    override fun initObservers() {

    }

    override fun saveCategories() {
        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.getFireBaseCategory()

        }
    }

    override fun setUpSearchView() {
        binding.toolbarLayout.searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.toolbarLayout.searchView.clearFocus()
                if (myAdapter.getNamesListFromObjectList(MyMockData().cateList)
                        .contains(query)
                ) {
                    myAdapter.filter.filter(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                myAdapter.filter.filter(newText)
                return false
            }
        })
    }

    override fun initRecyclerView() {
        myAdapter = MenuAdapter(this)
        binding.rvMenu.adapter = myAdapter


        lifecycleScope.launch {

            viewModel.getCategoryList().collect {
                myAdapter.submitFilterList(it)
            }
        }
    }


    override fun onItemClicked(itemId: Int, category: Category) {

        val bundle = Bundle()
        bundle.putString(
            Constants.CATE_ITEM_ID,
            category.categoryId.toString()
        )
        bundle.putString(
            Constants.CATE_ITEM_NAME,
            category.name
        )

        Navigation.navToMenuItemsFragment(findNavController(), bundle)
    }

}