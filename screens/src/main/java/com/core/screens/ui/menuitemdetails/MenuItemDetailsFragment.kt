package com.core.screens.ui.menuitemdetails

import android.content.ContentValues
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.core.base.BaseFragment
import com.core.domain.entities.Favorites
import com.core.domain.entities.OrderProduct
import com.core.screens.Navigation
import com.core.screens.R
import com.core.screens.databinding.FragmentMenuItemDetailsBinding
import com.core.utils.constants.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MenuItemDetailsFragment :
    BaseFragment<FragmentMenuItemDetailsBinding, MenuItemDetailsViewModel>(),
    IMenuItemDetailsFragment {

    lateinit var itemId: String
    lateinit var itemName: String
    var itemPrice: Double = 0.0
    var favorite = Favorites()
    var order = OrderProduct()

    override val viewModel: MenuItemDetailsViewModel by viewModels()

    override fun layoutId(): Int = R.layout.fragment_menu_item_details

    override fun init() {


        val favImage = binding.favButtonBar.ivAddFavourite
        val qtyLayout = binding.favButtonBar.qtyLayout
        favImage.setOnClickListener {
            favImage.setImageResource(R.drawable.fav_selected)
            addToFavorites()
        }

        qtyLayout.addQty.setOnClickListener {
            increaseQuantity()
        }

        qtyLayout.subtractQty.setOnClickListener {
            decreaseQuantity()
        }

        lifecycleScope.launch {
            checkFavorite()
        }

        lifecycleScope.launchWhenCreated {
            initViews()
        }


        binding.addToBasketBtn.setOnClickListener {
            addToBasket()
            Navigation.navigateBack(it)
        }

        super.init()
    }

    override suspend fun initViews() {
        arguments?.let { bundle ->
            if (bundle.containsKey(Constants.CATE_ITEM_NAME)) {
                itemName = bundle.getString(Constants.CATE_ITEM_NAME).toString()
                binding.favButtonBar.itemTitle.text = itemName
            }

            if (bundle.containsKey(Constants.CATE_ITEM_ID)) {
                itemId = bundle.getString(Constants.CATE_ITEM_ID).toString()
                itemPrice = bundle.getDouble(Constants.PRICE)
                Log.d(ContentValues.TAG, "MY Item Price $itemPrice")
                if (!TextUtils.isEmpty(itemId)) {
                    viewModel.getProductById(itemId.toInt()).collect { product ->
                        binding.itemObj = product
                    }
                }
            }
        }
    }

    override suspend fun checkFavorite() {
        viewModel.getFavorites().collect { favs ->
            try {
                for (fav in favs) {
                    if (fav.favoritesId == itemId.toInt()) {
                        binding.favButtonBar.ivAddFavourite.setImageResource(R.drawable.fav_selected)
                    }
                }

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun increaseQuantity() {
        var qtyCount = viewModel.getProducts().value.qty
        qtyCount = qtyCount.plus(1)
        viewModel.setCounter(qtyCount)
        viewModel.getProducts().value.qty = qtyCount
        binding.favButtonBar.qtyLayout.qty.text = qtyCount.toString()
    }

    override fun decreaseQuantity() {
        if (viewModel.getProducts().value.qty > 1) {
            var qtyCount = viewModel.getProducts().value.qty
            qtyCount = qtyCount.minus(1)
            viewModel.getProducts().value.qty = qtyCount
            binding.favButtonBar.qtyLayout.qty.text = qtyCount.toString()
        }
    }

    override fun addToFavorites() {
        viewModel.getProducts().value.isFavorite = true
        favorite.let {
            it.favoritesId = itemId.toInt()
            it.name = itemName
            it.isFavorite = true
        }
        viewModel.saveToFavorites(favorite)
    }

    override fun addToBasket() {
        try {
            order.let {
                it.ProductId = itemId.toInt()
                it.name = itemName
                it.qty = viewModel.getProducts().value.qty
                it.price = itemPrice
            }
            viewModel.saveToOrderProduct(order)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun initListeners() {

    }

    override fun initObservers() {

    }
}