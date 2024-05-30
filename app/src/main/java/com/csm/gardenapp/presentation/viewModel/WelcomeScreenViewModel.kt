package com.csm.gardenapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.csm.gardenapp.data.util.AUTH

class WelcomeScreenViewModel : ViewModel() {
    fun checkIfLoggedIn(onLoggedIn: () -> Unit) {
        AUTH.currentUser?.let { onLoggedIn() }
    }
}