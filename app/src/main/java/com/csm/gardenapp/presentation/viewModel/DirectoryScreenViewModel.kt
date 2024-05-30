package com.csm.gardenapp.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csm.gardenapp.data.repository.PlantsRepository
import com.csm.gardenapp.domain.model.Plant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class DirectoryScreenViewModel : ViewModel() {
    private var _query = mutableStateOf("")
    val query by _query

    private var _plants = mutableStateListOf<Plant>()
    var plants: List<Plant> = _plants

    fun filter(query: String) {
        plants = _plants.filter { plant ->
            plant.name.contains(query, ignoreCase = true)
        }.toList()
    }
    fun onQueryChange(query: String) {
        _query.value = query
        filter(query)
    }
    private fun loadPlants() = viewModelScope.launch(Dispatchers.IO) {
        val plants = PlantsRepository.loadPlants()
        _plants.clear()
        _plants.addAll(plants)
    }

    init {
        loadPlants()
    }
}