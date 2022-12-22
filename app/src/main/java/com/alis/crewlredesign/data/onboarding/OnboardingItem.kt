package com.alis.crewlredesign.data.onboarding

data class OnboardingItem(
    val id: Long = counter++,
    val image: Int,
    val title: String,
    val description: String
) {
    companion object {
        private var counter = 0L
    }
}
