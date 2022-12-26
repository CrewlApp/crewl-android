package com.alis.crewlredesign.ui.fragment.prelogin

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.alis.crewlredesign.core.BaseFragment
import com.alis.crewlredesign.databinding.FragmentLoginBinding
import com.alis.crewlredesign.databinding.FragmentPreloginBinding
import com.alis.crewlredesign.utils.autoCleared
import com.alis.crewlredesign.utils.navigateSafely

class PreLoginFragment : BaseFragment<PreLoginFragmentViewModel, FragmentPreloginBinding>() {
    private var binding: FragmentPreloginBinding by autoCleared()

    override fun getViewModel(): Class<PreLoginFragmentViewModel> = PreLoginFragmentViewModel::class.java

    override fun getViewBinding(): FragmentPreloginBinding = FragmentPreloginBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?, viewModel: PreLoginFragmentViewModel, binding: FragmentPreloginBinding) {
        this@PreLoginFragment.binding = binding
        
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        })
    }

    override fun setUIAction() {
        binding.leftButton.scaleX = -1.0f

        binding.leftButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.rightButton.setOnClickListener {
            findNavController().navigateSafely(PreLoginFragmentDirections.actionPreLoginFragmentToLoginFragment())
        }
    }

    override fun navigate(direction: NavDirections) {
    }

}