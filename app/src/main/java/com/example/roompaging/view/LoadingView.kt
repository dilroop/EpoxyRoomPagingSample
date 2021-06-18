package com.example.roompaging.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.airbnb.epoxy.ModelView

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class LoadingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    init {
        orientation = VERTICAL
        val progressBar = ProgressBar(this.context)
        progressBar.isIndeterminate = true
        this.addView(progressBar)
        setBackgroundColor(Color.RED)
        setPadding(0, 16, 0, 16)
    }
}
