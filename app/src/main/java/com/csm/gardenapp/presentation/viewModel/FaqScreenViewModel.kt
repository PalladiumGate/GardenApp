package com.csm.gardenapp.presentation.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csm.gardenapp.data.repository.FaqRepository
import com.csm.gardenapp.domain.model.Faq
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FaqScreenViewModel : ViewModel() {
    private var _faqs = mutableStateListOf<Faq>()
    var faqs: List<Faq> = _faqs

    private fun loadFaqs() = viewModelScope.launch(Dispatchers.IO) {
        val faqs = FaqRepository.loadFaq()
        _faqs.clear()
        _faqs.addAll(faqs)
    }

    init {
        loadFaqs()
    }
}