package com.alis.crewlredesign.ui.fragment.onboarding

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.alis.crewlredesign.core.BaseFragment
import com.alis.crewlredesign.databinding.FragmentOnboardingBinding
import com.alis.crewlredesign.ui.fragment.onboarding.adapter.OnboardingItemAdapter
import com.alis.crewlredesign.ui.fragment.onboarding.adapter.OnboardingItemAdapter.Companion.FIRST_ITEM
import com.alis.crewlredesign.utils.autoCleared
import com.alis.crewlredesign.utils.navigateSafely
import com.yuyakaido.android.cardstackview.*

class OnboardingFragment : BaseFragment<OnboardingFragmentViewModel, FragmentOnboardingBinding>(), CardStackListener {
    private var binding: FragmentOnboardingBinding by autoCleared()
    private val viewModel: OnboardingFragmentViewModel by viewModels()

    private lateinit var manager: CardStackLayoutManager

    private val adapter by lazy { OnboardingItemAdapter() }

    override fun getViewModel(): Class<OnboardingFragmentViewModel> = OnboardingFragmentViewModel::class.java

    override fun getViewBinding(): FragmentOnboardingBinding = FragmentOnboardingBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?, viewModel: OnboardingFragmentViewModel, binding: FragmentOnboardingBinding) {
        this@OnboardingFragment.binding = binding

        manager = CardStackLayoutManager(context, this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
    }

    override fun setUIAction() {
        setOnboardingItems()
    }

    private fun setOnboardingItems() {
        adapter.setItems(viewModel.onboardingItems)

        manager.apply {
            setStackFrom(StackFrom.BottomAndRight)
            setVisibleCount(5)
            setTranslationInterval(5.0f)
            setScaleInterval(1.0f)
            setMaxDegree(0.0f)
            setCanScrollHorizontal(true)
            setCanScrollVertical(false)
        }

        binding.apply {
            onboardingCardStack.apply {
                adapter = this@OnboardingFragment.adapter
                layoutManager = manager
            }

            leftButton.apply {
                scaleX = -1.0f
                setOnClickListener {
                    val setting = RewindAnimationSetting.Builder().setDirection(Direction.Left)
                        .setDuration(Duration.Normal.duration).setInterpolator(DecelerateInterpolator())
                        .build()

                    manager.setRewindAnimationSetting(setting)
                    onboardingCardStack.rewind()
                }
            }
        }
    }

    override fun navigate(direction: NavDirections) {
        findNavController().navigateSafely(direction = direction)
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {}

    override fun onCardSwiped(direction: Direction?) {}

    override fun onCardRewound() {}

    override fun onCardCanceled() {}

    override fun onCardAppeared(view: View?, position: Int) {
        binding.apply {
            leftButton.visibility = if (position == FIRST_ITEM) GONE else VISIBLE

            rightButton.setOnClickListener {
                if (position == 4) {
                    navigate(direction = OnboardingFragmentDirections.toPreLogin())
                } else {
                    val setting = SwipeAnimationSetting.Builder().setDirection(Direction.Left)
                        .setDuration(Duration.Normal.duration).setInterpolator(AccelerateInterpolator())
                        .build()

                    manager.setSwipeAnimationSetting(setting)
                    onboardingCardStack.swipe()
                }
            }
        }
    }

    override fun onCardDisappeared(view: View?, position: Int) {}
}