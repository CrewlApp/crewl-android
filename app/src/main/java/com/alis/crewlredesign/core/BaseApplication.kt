package com.alis.crewlredesign.core

import android.app.Application
import android.content.Context

class BaseApplication: Application() {
    companion object {
        private lateinit var applicationContext: Context
        @JvmStatic
        fun getContext(): Context = applicationContext
    }

    override fun onCreate() {
        super.onCreate()

        BaseApplication.applicationContext = this.applicationContext
    }
}