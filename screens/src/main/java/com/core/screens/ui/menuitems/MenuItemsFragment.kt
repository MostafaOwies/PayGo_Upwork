package com.core.screens.ui.menuitems

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.core.base.BaseFragment
import com.core.data.data.MyMockData
import com.core.domain.entities.Favorites
import com.core.domain.entities.Product
import com.core.screens.Navigation
import com.core.screens.R
import com.core.screens.databinding.FragmentMenuItemsBinding
import com.core.utils.constants.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MenuItemsFragment : BaseFragment<FragmentMenuItemsBinding, MenuItemsViewModel>(),
    IMenuItemsFragment, MenuItemClickListener, AddToFavorites {

    private lateinit var myAdapter: MenuItemsAdapter

    private lateinit var navController: NavController

    lateinit var itemId: String

    var favorite = Favorites()

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

    override val viewModel: MenuItemsViewModel by viewModels()

    override fun layoutId(): Int = R.layout.fragment_menu_items

    override fun init() {


        saveProducts()

        initViews()

        lifecycleScope.launch(Dispatchers.IO) {
            initRecyclerView()
        }

        super.init()
    }

    override fun initListeners() {
        setUpSearchView()
    }

    override fun initObservers() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = androidx.navigation.Navigation.findNavController(view)
    }

    override fun saveProducts() {
        lifecycleScope.launch(Dispatchers.IO) {
            MyMockData().productList.forEach { viewModel.saveProducts(it) }
        }
    }

    private fun initViews() {
        binding.toolbarLayout.ivBack.visibility = View.VISIBLE
        binding.toolbarLayout.ivBack.setOnClickListener {
            Navigation.navigateBack(it)
        }
    }

    override fun setUpSearchView() {
        binding.toolbarLayout.searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.toolbarLayout.searchView.clearFocus()
                if (myAdapter.getNamesListFromObjectList(MyMockData().productList)
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

    override suspend fun initRecyclerView() {
        myAdapter = MenuItemsAdapter(this, this)
        binding.menuItemsRv.adapter = myAdapter
        arguments?.let { bundle ->
            if (bundle.containsKey(Constants.CATE_ITEM_ID)) {
                itemId = bundle.getString(Constants.CATE_ITEM_ID).toString()
                if (!TextUtils.isEmpty(itemId)) {
                    viewModel.getProductList(itemId.toInt()).collect { product ->
                        myAdapter.submitFilterList(product)
                    }

                }
            }
        }
    }

    override fun onItemClicked(itemId: Int, product: Product) {
        val bundle = Bundle()
        bundle.putString(
            Constants.CATE_ITEM_ID,
            product.ProductId.toString()
        )
        bundle.putString(
            Constants.CATE_ITEM_NAME,
            product.name
        )
        bundle.putBoolean(
            Constants.IS_FAV,
            product.isFavorite
        )
        bundle.putDouble(
            Constants.PRICE,
            product.price
        )
        Navigation.navToMenuItemsDetailsFragment(findNavController(), bundle)
    }

    override fun onFavoritesClicked(itemId: Int, product: Product) {
        favorite.let {
            it.favoritesId = product.ProductId
            it.name = product.name
            it.isFavorite = true
        }
    }
}