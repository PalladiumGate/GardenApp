package com.csm.gardenapp.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csm.gardenapp.data.repository.PlantsRepository
import com.csm.gardenapp.domain.model.Plant
import com.csm.gardenapp.domain.util.mapMonthRusEng
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CalendarScreenViewModel : ViewModel() {
    private val _selectedMonth = mutableStateOf("Май")
    var selectedMonth by _selectedMonth
    
    var openDialog by mutableStateOf(false)

    private val _plants = mutableStateListOf<Plant>()
    var plants: List<Plant> = _plants.filter {
        it.month == selectedMonth
    }
    
    fun selectMonth(month: String) {
        _selectedMonth.value = mapMonthRusEng(month.trim())
        filter()
    }

    private fun filter() {
        plants = _plants.filter {
            it.month == selectedMonth
        }
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