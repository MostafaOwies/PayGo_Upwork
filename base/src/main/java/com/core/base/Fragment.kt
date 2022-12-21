package com.core.base

import android.content.Context
import android.view.View
import androidx.navigation.NavController

val BaseFragment<*, *>.viewContainer: View get() = (activity as BaseNavigationActivity<*, *>).getContainer()

val BaseFragment<*, *>.appContext: Context get() = activity?.applicationContext!!

val BaseFragment<*, *>.navController: NavController get() = (activity as BaseNavigationActivity<*, *>).getNavController()
