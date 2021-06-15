package com.example.roompaging

import com.airbnb.mvrx.MavericksState

data class FirstFragmentState(
    val title: String = "Test"
) : MavericksState
