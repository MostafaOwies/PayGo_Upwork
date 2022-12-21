package com.core.base

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import java.util.*


abstract class BaseNavigationActivity<BINDING : ViewDataBinding, VM : BaseViewModel> :
    AppCompatActivity() {
    protected lateinit var binding: BINDING
    protected abstract val viewModel: VM

    private val navHostFragment: NavHostFragment by lazy {
        supportFragmentManager.findFragmentById(navigationFragmentId()) as NavHostFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setLanguage("ar")

        binding = DataBindingUtil.setContentView(this, layoutRes())

        val inflater = getNavController().navInflater
        val graph = inflater.inflate(navigationGraphId())
        graph.setStartDestination(getNavStartDestination())
        getNavController().graph = graph
    }

    private fun setLanguage(lang: String) {
        val config = resources.configuration
        val locale = Locale(lang)
        Locale.setDefault(locale)
        config.setLocale(locale)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            createConfigurationContext(config)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    @SuppressLint("ResourceType")
    fun getNavController(): NavController = navHostFragment.findNavController()

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }

    @LayoutRes
    protected abstract fun layoutRes(): Int

    protected abstract fun navigationFragmentId(): Int

    @NavigationRes
    protected abstract fun navigationGraphId(): Int

    protected abstract fun getNavStartDestination(): Int

    abstract fun getContainer(): View
}