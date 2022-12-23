package com.alis.crewlredesign.ui.fragment.onboarding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alis.crewlredesign.R
import com.alis.crewlredesign.data.onboarding.OnboardingItem

class OnboardingItemAdapter : RecyclerView.Adapter<OnboardingItemAdapter.OnboardingViewHolder>() {
    companion object {
        const val FIRST_ITEM = 0
        const val LAST_ITEM = 4
    }

    private lateinit var onboardingItems: MutableList<OnboardingItem>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return OnboardingViewHolder(inflater.inflate(R.layout.item_card_onboarding, parent, false))
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        val onboardingItem = onboardingItems[position]

        holder.title.text = onboardingItem.title
        holder.description.text = onboardingItem.description
        holder.image.setImageResource(onboardingItem.image)
    }

    override fun getItemCount(): Int {
        return onboardingItems.size
    }

    fun setItems(items: List<OnboardingItem>) {
        this.onboardingItems = items as MutableList<OnboardingItem>
    }

    fun getItems(): List<OnboardingItem> {
        return onboardingItems
    }

    class OnboardingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.titleOnboarding_text)
        var description: TextView = view.findViewById(R.id.descriptionOnboarding_text)
        var image: ImageView = view.findViewById(R.id.imageOnboarding)
    }
}