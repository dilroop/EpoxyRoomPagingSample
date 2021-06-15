package com.example.roompaging.epoxy

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.airbnb.epoxy.EpoxyController
import com.airbnb.mvrx.MavericksView

abstract class EpoxyFragment : Fragment(), MavericksView {
    protected val epoxyController by lazy { epoxyController() }

    protected abstract fun epoxyController(): EpoxyController

    override fun onCreate(savedInstanceState: Bundle?) {
        epoxyController.onRestoreInstanceState(savedInstanceState)
        super.onCreate(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        epoxyController.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        epoxyController.cancelPendingModelBuild()
        super.onDestroyView()
    }
}
