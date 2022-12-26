package com.alis.crewlredesign.ui.fragment.login

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.alis.crewlredesign.R
import com.alis.crewlredesign.core.BaseFragment
import com.alis.crewlredesign.databinding.FragmentLoginBinding
import com.alis.crewlredesign.databinding.FragmentOnboardingBinding
import com.alis.crewlredesign.ui.fragment.onboarding.OnboardingFragmentViewModel
import com.alis.crewlredesign.utils.autoCleared

class LoginFragment : BaseFragment<LoginFragmentViewModel, FragmentLoginBinding>() {
    private var binding: FragmentLoginBinding by autoCleared()

    override fun getViewModel(): Class<LoginFragmentViewModel> = LoginFragmentViewModel::class.java

    override fun getViewBinding(): FragmentLoginBinding = FragmentLoginBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?, viewModel: LoginFragmentViewModel, binding: FragmentLoginBinding) {
        this@LoginFragment.binding = binding

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        })
    }

    override fun setUIAction() {
        binding.leftButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun navigate(direction: NavDirections) {
    }

}