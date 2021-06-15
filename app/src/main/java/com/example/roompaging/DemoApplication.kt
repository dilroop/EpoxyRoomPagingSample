package com.example.roompaging

import android.app.Application
import com.airbnb.mvrx.Mavericks

class DemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }
}
