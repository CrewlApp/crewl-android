/**
 * @author Kaan Fırat
 *
 * Last updated time : 3 September 2022 05:33
 */

package com.alis.crewlredesign.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VM : ViewModel, VB : ViewBinding> : Fragment() {
    private lateinit var binding: VB
    private lateinit var viewModel: VM

    protected val Fragment.name: String by lazy { javaClass.simpleName }

    protected abstract fun getViewModel(): Class<VM>

    protected abstract fun getViewBinding(): VB

    protected abstract fun onCreate(savedInstanceState: Bundle?, viewModel: VM, binding: VB)

    protected abstract fun setUIAction()

    protected abstract fun navigate(direction: NavDirections)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = getViewBinding()

        viewModel = ViewModelProvider(this)[getViewModel()]

        onCreate(savedInstanceState, viewModel, binding)

        setUIAction()

        return binding.root
    }
}