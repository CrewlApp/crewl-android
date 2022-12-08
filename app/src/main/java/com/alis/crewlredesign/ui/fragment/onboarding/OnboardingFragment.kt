package com.alis.crewlredesign.ui.fragment.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.alis.crewlredesign.R
import com.alis.crewlredesign.core.BaseApplication
import com.alis.crewlredesign.core.BaseFragment
import com.alis.crewlredesign.data.onboarding.OnboardingItem
import com.alis.crewlredesign.databinding.FragmentOnboardingBinding
import com.alis.crewlredesign.ui.fragment.onboarding.adapter.OnboardingItemAdapter
import com.alis.crewlredesign.utils.autoCleared
import com.alis.crewlredesign.utils.navigateSafely

class OnboardingFragment : BaseFragment<OnboardingFragmentViewModel, FragmentOnboardingBinding>() {
    private var binding: FragmentOnboardingBinding by autoCleared()
    private val viewModel: OnboardingFragmentViewModel by viewModels()

    private lateinit var onboardingItemAdapter: OnboardingItemAdapter

    override fun getViewModel(): Class<OnboardingFragmentViewModel> = OnboardingFragmentViewModel::class.java

    override fun getViewBinding(): FragmentOnboardingBinding = FragmentOnboardingBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?, viewModel: OnboardingFragmentViewModel, binding: FragmentOnboardingBinding) {
        this@OnboardingFragment.binding = binding
    }

    override fun setUIAction() {
        setOnboardingItems()
        setIndicators()
        setCurrentIndicator(position = 0)
    }

    private fun setOnboardingItems() {
        onboardingItemAdapter = OnboardingItemAdapter(
            listOf(
                OnboardingItem(
                    emote = R.drawable.emote_rabbit_cigarette,
                    title = getString(R.string.welcome_to_the_crewl),
                    description = getString(R.string.best_pub_event_in_town)
                ),
                OnboardingItem(
                    emote = R.drawable.emote_rabbit_event,
                    title = getString(R.string.explore_events_in_town),
                    description = getString(R.string.create_events_for_users_or_join)
                ),
                OnboardingItem(
                    emote = R.drawable.emote_bears_meet_people,
                    title = getString(R.string.meet_new_people_and_challenge),
                    description = getString(R.string.find_people_in_town)
                ),
                OnboardingItem(
                    emote = R.drawable.emote_fox_discount,
                    title = getString(R.string.earn_special_discounts),
                    description = getString(R.string.enjoy_crewl_discounts)
                )
            )
        )

        binding.apply {
            onboardingViewPager.adapter = onboardingItemAdapter
            onboardingViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    setCurrentIndicator(position = position)
                }

                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                    if (onboardingViewPager.currentItem + 1 < onboardingItemAdapter.itemCount)
                        onboardingButton.visibility = View.INVISIBLE
                    else
                        onboardingButton.visibility = View.VISIBLE
                }
            })
            (onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

            onboardingButton.setOnClickListener {
                if (onboardingViewPager.currentItem + 1 < onboardingItemAdapter.itemCount) {
                    onboardingViewPager.currentItem += 1
                }
            }
        }
    }

    private fun setIndicators() {
        val indicators = arrayOfNulls<ImageView>(onboardingItemAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(5, 0, 5, 0)

        indicators.indices.forEach { item ->
            indicators[item] = ImageView(BaseApplication.getContext())
            indicators[item]?.let { image ->
                image.setImageDrawable(
                    ContextCompat.getDrawable(
                        BaseApplication.getContext(),
                        R.drawable.item_indicator_passive
                    )
                )
                image.layoutParams = layoutParams
                binding.onboardingIndicator.addView(image)
            }
        }
    }

    private fun setCurrentIndicator(position: Int) {
        val childCount = binding.onboardingIndicator.childCount

        for (i in 0 until childCount) {
            val image = binding.onboardingIndicator.getChildAt(i) as ImageView

            if (i == position)
                image.setImageDrawable(
                    ContextCompat.getDrawable(
                        BaseApplication.getContext(),
                        R.drawable.item_indicator_active
                    )
                )
            else
                image.setImageDrawable(
                    ContextCompat.getDrawable(
                        BaseApplication.getContext(),
                        R.drawable.item_indicator_passive
                    )
                )
        }
    }

    override fun navigate(direction: NavDirections) {
        findNavController().navigateSafely(direction = direction)
    }
}