package com.core.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.core.screens.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUpBottomNav()


    }

    private fun setUpBottomNav() {
        navController = findNavController(R.id.navHostFragment)
        binding?.bottomNavigation?.setupWithNavController(navController)

        binding?.bottomNavigation?.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.billFragment -> {
                    Navigation.navToBillFragment(navController)
                }
                R.id.menuFragment -> {
                    Navigation.navToMenuFragment(navController)
                }
                R.id.favoritesFragment -> {
                    Navigation.navToFavouritesFragment(navController)
                }
                R.id.basketFragment -> {
                    Navigation.navToBasketFragment(navController)
                }
                R.id.moreFragment -> {
                    Navigation.navToMoreFragment(navController)
                }
            }
            false
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

//    private lateinit var binding: ActivityMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val navView: BottomNavigationView = binding.navView
//
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
//    }
}