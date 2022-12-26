package com.alis.crewlredesign.ui.fragment.onboarding

import androidx.lifecycle.ViewModel
import com.alis.crewlredesign.R
import com.alis.crewlredesign.data.onboarding.OnboardingItem
import com.alis.crewlredesign.utils.ResourceHelper.getString

class OnboardingFragmentViewModel : ViewModel() {
    val onboardingItems: List<OnboardingItem>
        get() = getOnboardingData()

    private fun getOnboardingData(): List<OnboardingItem> {
        return listOf(
            OnboardingItem(
                image = R.drawable.image_onboarding_welcome,
                title = getString(R.string.welcome_to_the_crewl),
                description = getString(R.string.best_pub_event_in_town)
            ),
            OnboardingItem(
                image = R.drawable.image_onboarding_welcome,
                title = getString(R.string.explore_events_in_town),
                description = getString(R.string.create_events_for_users_or_join)
            ),
            OnboardingItem(
                image = R.drawable.image_onboarding_welcome,
                title = getString(R.string.meet_new_people_and_challenge),
                description = getString(R.string.find_people_in_town)
            ),
            OnboardingItem(
                image = R.drawable.image_onboarding_welcome,
                title = getString(R.string.earn_special_discounts),
                description = getString(R.string.enjoy_crewl_discounts)
            ),
            OnboardingItem(
                image = R.drawable.image_onboarding_welcome,
                title = getString(R.string.earn_special_discounts),
                description = getString(R.string.enjoy_crewl_discounts)
            )
        )
    }
}