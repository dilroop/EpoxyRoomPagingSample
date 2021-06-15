package com.example.roompaging

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.example.room.User
import com.example.roompaging.databinding.ViewUserBinding

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class UserView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding: ViewUserBinding =
        ViewUserBinding.inflate(LayoutInflater.from(context), this)

    @ModelProp
    fun setUser(user: User) {
        binding.email.text = user.email
        binding.firstName.text = user.firstName
        binding.lastName.text = user.lastName
    }
}
