package com.core.base

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.core.network.exception.Failure
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.loading.*

/**
 * Base Fragment class with helper methods for handling views and back button events.
 *
 * @see Fragment
 */
abstract class BaseFragment<BINDING : ViewDataBinding, VM : BaseViewModel> : Fragment() {
    private lateinit var dialogBuilder: AlertDialog.Builder
    private lateinit var snackBar: Snackbar
    protected lateinit var binding: BINDING
    protected abstract val viewModel: VM
    var savedInstanceState: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        this.savedInstanceState = savedInstanceState
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<BINDING>(
            layoutInflater, layoutId(), container, false
        )?.also {
            binding = it
        }?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this

        init()

        initListeners()

        initObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }

    @LayoutRes
    abstract fun layoutId(): Int

    open fun init() {}

    abstract fun initListeners()

    abstract fun initObservers()

    open fun onBackPressed() {}

    internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState == null

    internal fun showProgress(loadingMessage: Int? = null) {
        activity?.window?.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
        var msg = ""
        loadingMessage?.let {
            getString(it).let { str ->
                msg = str
            }
        }
        with(activity) {
            if (this is BaseNavigationActivity<*, *>) this.tv_loading.text = msg
        }

        progressStatus(View.VISIBLE)
    }

    internal fun hideProgress() {
        progressStatus(View.GONE)
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    internal fun hideSnackBar() {
        if (::snackBar.isInitialized)
            snackBar.dismiss()
    }

    internal fun navigateTo(navigationPair: Pair<Int, Bundle?>?) {
        hideSnackBar()
        hideProgress()

        navigationPair?.first?.let { navController.navigate(it, navigationPair.second) }
    }

    private fun progressStatus(viewStatus: Int) =
        with(activity) {
            if (this is BaseNavigationActivity<*, *>) this.progress.visibility = viewStatus
        }

    internal fun notify(@StringRes message: Int) =
        Snackbar.make(viewContainer, message, Snackbar.LENGTH_SHORT).show()

    private fun notifyWithAction(
        @StringRes message: Int,
        @StringRes actionText: Int,
        action: () -> Any
    ) {
        snackBar = Snackbar.make(viewContainer, message, Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction(actionText) { action.invoke() }
        snackBar.setActionTextColor(ContextCompat.getColor(appContext, R.color.white_base))
        snackBar.show()
    }

    private fun notifyRetry(@StringRes message: Int, action: () -> Any) {
        notifyWithAction(message, R.string.retry, action)
    }

    internal fun showDialog(message: String?) {
        showDialogOption(
            message,
            getString(R.string.ok)
        ) { dialogInterface, i -> dialogInterface.dismiss() }
    }

    fun showDialogOption(
        message: String?,
        positiveName: String?,
        positiveAction: DialogInterface.OnClickListener
    ) {
        dialogBuilder = AlertDialog.Builder(requireActivity())
        dialogBuilder.setMessage(message)
            .setCancelable(false)
            .setPositiveButton(positiveName, positiveAction)
        val alert = dialogBuilder.create()
        if (!isRemoving)
            alert.show()
    }

    internal fun handleGlobalFailure(failure: Failure?, action: () -> Any) {
        when (failure) {
            is Failure.NetworkConnection -> notifyRetry(R.string.failure_network_connection, action)
            is Failure.ServerError -> notifyRetry(R.string.failure_server_error, action)
            else -> notifyRetry(R.string.error, action)
        }
    }

    fun addSpinner(spinner: Spinner, adapterList: List<Any>) {
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, adapterList)
        spinner.adapter = adapter
    }
}
