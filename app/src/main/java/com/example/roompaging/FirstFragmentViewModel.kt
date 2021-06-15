package com.example.roompaging

import android.app.Application
import android.util.Log
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.example.room.User
import com.example.room.UserRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class FirstFragmentViewModel(
    application: Application,
    initialState: FirstFragmentState
) : MavericksViewModel<FirstFragmentState>(initialState) {
    private val repository = UserRepository(application)
    fun getUsers() = repository.getAll()
    fun insertOrders(users: List<User>) = GlobalScope.launch {
        repository.insertAll(*users.toTypedArray())
    }

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