package com.csm.gardenapp.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.csm.gardenapp.data.repository.NotesRepository
import com.csm.gardenapp.data.util.AUTH
import com.csm.gardenapp.domain.util.Result
import com.google.android.play.integrity.internal.o
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteScreenViewModel : ViewModel() {
    private val _loadingState = mutableStateOf(false)
    var loadingState by _loadingState

    var error: String? by mutableStateOf(null)

    fun createUpdNote(note: com.csm.gardenapp.domain.model.Note, onFinished: () -> Unit) = viewModelScope.launch(Dispatchers.IO) {
        _loadingState.value = true
        AUTH.currentUser?.uid?.let { uid ->
            NotesRepository.createUpdateNote(uid, note, onFinished = {
                _loadingState.value = false
                when(it) {
                    is Result.Success<*> -> {
                        onFinished()
                    }
                    is Result.Error -> {
                        error = "Ошибка сохранения заметки"
                    }
                }
            })
        }
    }
}