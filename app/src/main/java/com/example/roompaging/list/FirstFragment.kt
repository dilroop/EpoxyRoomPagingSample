package com.example.roompaging.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.example.room.User
import com.example.roompaging.databinding.FragmentFirstBinding
import com.example.roompaging.view.LoadingViewModel_
import com.example.roompaging.view.UserViewModel_
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class FirstFragment : Fragment(), MavericksView {

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
        binding.recycler.adapter = viewModel.pagedController.adapter
        viewModel.pagedList.observe(viewLifecycleOwner) {
            viewModel.pagedController.submitList(it)
        }
    }

    override fun invalidate() { }
}

class UserPagedListController() : PagedListEpoxyController<User>() {
    override fun buildItemModel(currentPosition: Int, item: User?): EpoxyModel<*> {

        return if (item == null) {
            LoadingViewModel_().id(currentPosition)
        } else {
            UserViewModel_().id(currentPosition).user(item)
        }
    }
}