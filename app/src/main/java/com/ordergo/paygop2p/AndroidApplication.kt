package com.ordergo.paygop2p


//import androidx.databinding.DataBindingUtil
import androidx.multidex.MultiDexApplication
//import com.core.screens.binding.BindingComponentBuilder
import dagger.hilt.android.HiltAndroidApp

//import javax.inject.Inject
//import javax.inject.Provider


@HiltAndroidApp
class AndroidApplication : MultiDexApplication() {
//    @Inject
//    lateinit var bindingComponentProvider: Provider<BindingComponentBuilder>

    override fun onCreate() {
        super.onCreate()
//        DataBindingUtil.setDefaultComponent(bindingComponentProvider.get().build())
    }
}