package com.core.screens.ui.favorites

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.core.base.BaseFragment
import com.core.domain.entities.Favorites
import com.core.screens.Navigation
import com.core.screens.R
import com.core.screens.databinding.FragmentFavoritesBinding
import com.core.utils.constants.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class FavoritesFragment : BaseFragment<FragmentFavoritesBinding, FavoritesViewModel>(),
    IFavouritesFragment, FavouriteClickListener {

    private lateinit var myAdapter: FavouritesAdapter

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

    override val viewModel: FavoritesViewModel by viewModels()

    override fun layoutId(): Int = R.layout.fragment_favorites

    override fun init() {
        setupRecyclerView()

        super.init()
    }

    override fun initListeners() {

    }

    override fun initObservers() {

    }

    override fun setupRecyclerView() {
        myAdapter = FavouritesAdapter(this)
        binding.favItemsRv.adapter = myAdapter

        lifecycleScope.launch {
            viewModel.getFavorites().collect {
                myAdapter.submitList(it)
            }
        }
    }

    override fun onItemClicked(itemId: Int, favorites: Favorites) {
        val bundle = Bundle()
        bundle.putString(
            Constants.CATE_ITEM_ID,
            favorites.favoritesId.toString()
        )
        bundle.putString(
            Constants.CATE_ITEM_NAME,
            favorites.name
        )
        Navigation.navToMenuItemsDetailsFragmentFromFav(findNavController(), bundle)
    }

    override fun onDeleteItemClicked(itemId: Int) {
        /* textList.find { it.id == itemId }.let {
             textList.remove(it)
         }
         myAdapter.notifyDataSetChanged()*/
    }
}