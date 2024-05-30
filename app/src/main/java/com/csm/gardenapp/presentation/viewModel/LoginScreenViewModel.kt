package com.csm.gardenapp.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.csm.gardenapp.data.util.AUTH

class LoginScreenViewModel : ViewModel() {
    private var _email = mutableStateOf("")
    val email by _email

    private var _password = mutableStateOf("")
    val password by _password

    private var _error = mutableStateOf<String?>(null)
    val error by _error

    fun updateEmail(value: String) {
        _email.value = value
    }

    fun updatePassword(value: String) {
        _password.value = value
    }

    fun login(onLoggedIn: () -> Unit) {
        if (email.isEmpty() || password.isEmpty()) {
            _error.value = "Заполните все поля"
            return
        }
        AUTH.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onLoggedIn()
                } else {
                    _error.value = "Неверный логин или пароль"
                }
            }
    }
}