package com.example.roompaging

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.fragmentViewModel
import com.example.roompaging.databinding.FragmentFirstBinding
import com.example.roompaging.epoxy.EpoxyFragment
import com.example.roompaging.epoxy.simpleController

class FirstFragment : EpoxyFragment() {

    private val viewModel: FirstFragmentViewModel by fragmentViewModel()
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recycler.setController(epoxyController)
    }

    override fun epoxyController() = simpleController(viewModel) { state ->
        mockUsers.forEach { user ->
            userView {
                id(user.email)
                user(user)
            }
        }
    }

    override fun invalidate() {
        binding.recycler.requestModelBuild()
    }
}
