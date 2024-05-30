package com.csm.gardenapp.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.csm.gardenapp.data.repository.UserRepository
import com.csm.gardenapp.data.util.AUTH
import com.csm.gardenapp.data.util.CHILD_EMAIL
import com.csm.gardenapp.data.util.CHILD_USERNAME
import com.csm.gardenapp.domain.util.Result

class RegisterScreenViewModel : ViewModel() {
    var loadingState by mutableStateOf(false) //true - loading, false - not loading

    private var _username = mutableStateOf("")
    var username by _username

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

    fun updateUsername(value: String) {
        _username.value = value
    }

    fun register(onRegistered: () -> Unit) {
        if (email.isEmpty() || password.isEmpty() || username.isEmpty()) {
            _error.value = "Заполните все поля"
            return
        }
        loadingState = true
        AUTH.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    task.result.user?.uid?.let{uid ->
                        UserRepository.createUser(
                            uid,
                            mapOf(
                                CHILD_EMAIL to email,
                                CHILD_USERNAME to username
                            )
                        ) {
                            loadingState = false
                            if (it.isSuccess()) {
                                onRegistered()
                            } else {
                                val err = it as Result.Error
                                _error.value = err.message
                            }
                        }
                    }
                } else {
                    loadingState = false
                    _error.value = "Ошибка: ${task.exception?.message ?: ""}"
                }
            }
    }
}