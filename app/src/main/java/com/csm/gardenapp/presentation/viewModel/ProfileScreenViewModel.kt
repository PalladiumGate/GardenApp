package com.csm.gardenapp.presentation.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csm.gardenapp.data.repository.UserRepository
import com.csm.gardenapp.data.util.AUTH
import com.csm.gardenapp.domain.model.User
import kotlinx.coroutines.launch

class ProfileScreenViewModel : ViewModel() {
    private val _user: MutableState<User?> = mutableStateOf(null)
    var user by _user

    private fun loadUser() = viewModelScope.launch {
        AUTH.currentUser?.uid?.let { uid ->
            val user = UserRepository.loadUser(uid)

            _user.value = user
        }
    }

    init {
        loadUser()
    }
}