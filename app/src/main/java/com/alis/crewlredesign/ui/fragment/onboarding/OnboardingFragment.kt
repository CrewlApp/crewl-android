package com.alis.crewlredesign.ui.fragment.onboarding

import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
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
import com.yuyakaido.android.cardstackview.*

class OnboardingFragment : BaseFragment<OnboardingFragmentViewModel, FragmentOnboardingBinding>(), CardStackListener {
    private var binding: FragmentOnboardingBinding by autoCleared()
    private val viewModel: OnboardingFragmentViewModel by viewModels()

    private val manager by lazy { CardStackLayoutManager(context, this) }
    private val adapter by lazy { OnboardingItemAdapter() }

    override fun getViewModel(): Class<OnboardingFragmentViewModel> = OnboardingFragmentViewModel::class.java

    override fun getViewBinding(): FragmentOnboardingBinding = FragmentOnboardingBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?, viewModel: OnboardingFragmentViewModel, binding: FragmentOnboardingBinding) {
        this@OnboardingFragment.binding = binding
    }

    override fun setUIAction() {
        setOnboardingItems()
    }

    private fun setOnboardingItems() {
        adapter.setItems(
            listOf(
                OnboardingItem(
                    image = R.drawable.image_onboarding_welcome,
                    title = getString(R.string.welcome_to_the_crewl),
                    description = getString(R.string.best_pub_event_in_town)
                ),
                OnboardingItem(
                    image = R.drawable.emote_rabbit_event,
                    title = getString(R.string.explore_events_in_town),
                    description = getString(R.string.create_events_for_users_or_join)
                ),
                OnboardingItem(
                    image = R.drawable.emote_bears_meet_people,
                    title = getString(R.string.meet_new_people_and_challenge),
                    description = getString(R.string.find_people_in_town)
                ),
                OnboardingItem(
                    image = R.drawable.emote_fox_discount,
                    title = getString(R.string.earn_special_discounts),
                    description = getString(R.string.enjoy_crewl_discounts)
                ),
                OnboardingItem(
                    image = R.drawable.emote_fox_discount,
                    title = getString(R.string.earn_special_discounts),
                    description = getString(R.string.enjoy_crewl_discounts)
                )
            )
        )

        manager.apply {
            setStackFrom(StackFrom.BottomAndRight)
            setVisibleCount(5)
            setTranslationInterval(5.5f)
            setScaleInterval(1.0f)
            setMaxDegree(0.0f)
            setCanScrollHorizontal(true)
            setCanScrollVertical(false)
        }

        binding.apply {
            onboardingCardStack.adapter = adapter
            onboardingCardStack.layoutManager = manager

            leftButton.setOnClickListener {
                val setting = RewindAnimationSetting.Builder().setDirection(Direction.Bottom)
                    .setDuration(Duration.Normal.duration).setInterpolator(DecelerateInterpolator())
                    .build()

                manager.setRewindAnimationSetting(setting)
                onboardingCardStack.rewind()
            }

            rightButton.setOnClickListener {
                val setting = SwipeAnimationSetting.Builder().setDirection(Direction.Right)
                    .setDuration(Duration.Normal.duration).setInterpolator(AccelerateInterpolator())
                    .build()

                manager.setSwipeAnimationSetting(setting)
                onboardingCardStack.swipe()
            }
        }
    }

    override fun navigate(direction: NavDirections) {
        findNavController().navigateSafely(direction = direction)
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
    }

    override fun onCardSwiped(direction: Direction?) {
    }

    override fun onCardRewound() {
    }

    override fun onCardCanceled() {
    }

    override fun onCardAppeared(view: View?, position: Int) {
    }

    override fun onCardDisappeared(view: View?, position: Int) {
    }
}