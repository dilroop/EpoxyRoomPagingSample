package com.example.roompaging.list

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.example.room.User
import com.example.room.UserRepository
import com.example.roompaging.DemoApplication
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class FirstFragmentViewModel(
    application: Application,
    initialState: FirstFragmentState
) : MavericksViewModel<FirstFragmentState>(initialState) {
    private val repository = UserRepository(application)

    val pagedController = UserPagedListController()

    fun getUsers() = repository.getAll()
    fun insertOrders(users: List<User>) = GlobalScope.launch {
        repository.insertAll(*users.toTypedArray())
    }

    val pagedList: LiveData<PagedList<User>> by lazy { repository.pagedList }

    init {
        Log.d("ViewModel", "Initialized")
    }

    companion object : MavericksViewModelFactory<FirstFragmentViewModel, FirstFragmentState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: FirstFragmentState
        ): FirstFragmentViewModel? {
            val app = viewModelContext.app<DemoApplication>()
            return FirstFragmentViewModel(app, FirstFragmentState())
        }
    }
}