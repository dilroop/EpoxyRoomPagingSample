package com.example.roompaging

import android.app.Application
import androidx.fragment.app.Fragment

fun Fragment.getApplication(): Application {
    return requireContext().applicationContext as DemoApplication
}