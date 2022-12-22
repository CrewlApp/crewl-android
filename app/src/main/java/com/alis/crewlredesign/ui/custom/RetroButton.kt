package com.alis.crewlredesign.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.LayoutRes
import com.alis.crewlredesign.databinding.CustomRetroButtonViewBinding

class RetroButton : LinearLayout {
    private lateinit var binding: CustomRetroButtonViewBinding

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = CustomRetroButtonViewBinding.inflate(inflater, this, true)
    }

    fun setButtonIcon(resourceId: Int) {
        binding.frontLayoutIcon.setImageResource(resourceId)
    }

    /*
    override fun setPressed(pressed: Boolean) {
        super.setPressed(pressed)
        if (pressed) {
            binding.frontLayout.visibility = GONE
            binding.shadow.visibility = GONE
        } else {
            binding.frontLayout.visibility = VISIBLE
            binding.shadow.visibility = VISIBLE
            binding.frontLayoutProgress.visibility = VISIBLE
            binding.frontLayoutIcon.visibility = GONE
            binding.buttonView.alpha = 0.5f
        }
    }
     */

    override fun dispatchSetPressed(pressed: Boolean) {
        super.dispatchSetPressed(pressed)
        Log.i("App.tag", "dispatchSetPressed: called.")
    }

}