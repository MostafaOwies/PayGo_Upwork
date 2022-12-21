package com.core.screens

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController

class Navigation {

    companion object {
        fun navigate(navController: NavController, id: Int, bundle: Bundle? = null) {
            navController.navigate(id, bundle)
        }

        fun navToBillFragment(navController: NavController, bundle: Bundle? = null) {
            navController.popBackStack(R.id.billFragment, false)
            navigate(navController, R.id.billFragment, bundle)
        }

        fun navToMenuFragment(navController: NavController, bundle: Bundle? = null) {
            navController.popBackStack(R.id.billFragment, false)
            navigate(navController, R.id.menuFragment, bundle)
        }

        fun navToFavouritesFragment(navController: NavController, bundle: Bundle? = null) {
            navController.popBackStack(R.id.billFragment, false)
            navigate(navController, R.id.favoritesFragment, bundle)
        }

        fun navToBasketFragment(navController: NavController, bundle: Bundle? = null) {
            navController.popBackStack(R.id.billFragment, false)
            navigate(navController, R.id.basketFragment, bundle)
        }

        fun navToMoreFragment(navController: NavController, bundle: Bundle? = null) {
            navController.popBackStack(R.id.billFragment, false)
            navigate(navController, R.id.moreFragment, bundle)
        }

        fun navToMenuItemsFragment(navController: NavController, bundle: Bundle? = null) {
            navigate(navController, R.id.action_menuFragment_to_menuItemsFragment, bundle)
        }

        fun navToMenuItemsDetailsFragment(navController: NavController, bundle: Bundle? = null) {
            navigate(
                navController,
                R.id.action_menuItemsFragment_to_menuItemDetailsFragment,
                bundle
            )
        }

        fun navToMenuItemsDetailsFragmentFromFav(
            navController: NavController,
            bundle: Bundle? = null
        ) {
            navigate(
                navController,
                R.id.action_favoritesFragment_to_menuItemDetailsFragment,
                bundle
            )
        }

        fun navToMenuItemsDetailsFragmentFromBasket(
            navController: NavController,
            bundle: Bundle? = null
        ) {
            navigate(navController, R.id.action_basketFragment_to_menuItemDetailsFragment, bundle)
        }

        fun navToTransactionFragment(navController: NavController, bundle: Bundle? = null) {
            navigate(navController, R.id.action_moreFragment_to_transactionFragment, bundle)
        }

        fun navigateBack(view: View) {
            try {
                view.post {
                    view.findNavController().popBackStack()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}