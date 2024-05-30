package com.csm.gardenapp.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.csm.gardenapp.data.repository.NotesRepository
import com.csm.gardenapp.domain.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesScreenViewModel : ViewModel() {
    private val _notes = mutableStateListOf<Note>()
    val notes: List<Note> = _notes

    private val _loadingState = mutableStateOf(false)
    var loadingState by _loadingState

    fun loadNotes() = viewModelScope.launch(Dispatchers.Main) {
        _loadingState.value = true
        val notes = NotesRepository.loadNotes()
        _notes.clear()
        _notes.addAll(notes)
        _loadingState.value = false
    }
}