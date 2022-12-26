package com.alis.crewlredesign.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import com.alis.crewlredesign.R
import com.alis.crewlredesign.core.BaseActivity
import com.alis.crewlredesign.databinding.ActivityMainBinding
import com.alis.crewlredesign.manager.ApplicationManager

class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    private var isFirstStart: Boolean = true

    override fun setStatusBarBackground() {}

    override fun getStatusBarHeight() {}

    override fun getViewModel(): Class<MainActivityViewModel> = MainActivityViewModel::class.java

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override val themeId: Int
        get() = R.style.Theme_Default

    override fun onCreate(savedInstanceState: Bundle?, viewModel: MainActivityViewModel, binding: ActivityMainBinding) {
        this@MainActivity.binding = binding
        this@MainActivity.viewModel = viewModel

        ApplicationManager.init()
    }

    override fun onStart() {
        super.onStart()

        if (isFirstStart) {
            isFirstStart = false

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onResume() {
        super.onResume()

    }

    override fun setStatusBarDark() {
        Log.i("Application.tag", "setStatusBarDark: called.")
    }
}