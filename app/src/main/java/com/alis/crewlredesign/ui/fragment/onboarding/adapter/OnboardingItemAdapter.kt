package com.alis.crewlredesign.ui.fragment.onboarding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alis.crewlredesign.R
import com.alis.crewlredesign.data.onboarding.OnboardingItem

class OnboardingItemAdapter(private val onboardingItems: List<OnboardingItem>): RecyclerView.Adapter<OnboardingItemAdapter.OnboardingItemViewHolder>() {
    inner class OnboardingItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val emote: ImageView = view.findViewById(R.id.imageOnboarding)
        private val title: TextView = view.findViewById(R.id.titleOnboarding)
        private val description: TextView = view.findViewById(R.id.descriptionOnboarding)

        fun bind(onboardingItem: OnboardingItem) {
            emote.setImageResource(onboardingItem.emote)
            title.text = onboardingItem.title
            description.text = onboardingItem.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewHolder {
        return OnboardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_onboarding, parent, false)
        )
    }

    override fun onBindViewHolder(holder: OnboardingItemViewHolder, position: Int) {
        holder.bind(onboardingItems[position])
    }

    override fun getItemCount(): Int = onboardingItems.size
}