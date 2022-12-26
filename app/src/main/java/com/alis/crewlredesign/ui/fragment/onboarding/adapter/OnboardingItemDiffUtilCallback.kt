package com.alis.crewlredesign.ui.fragment.onboarding.adapter

import androidx.recyclerview.widget.DiffUtil
import com.alis.crewlredesign.data.onboarding.OnboardingItem

class OnboardingItemDiffUtilCallback(private val old: List<OnboardingItem>, private val new: List<OnboardingItem>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = old.size

    override fun getNewListSize(): Int = new.size

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean = old[oldPosition].id == new[newPosition].id

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean = old[oldPosition] == new[newPosition]
}