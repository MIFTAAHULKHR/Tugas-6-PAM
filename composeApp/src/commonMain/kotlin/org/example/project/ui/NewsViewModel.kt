package org.example.project.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.project.data.Article
import org.example.project.data.NewsApi
import org.example.project.data.NewsRepository

sealed class NewsState {
    object Loading : NewsState()
    data class Success(val articles: List<Article>) : NewsState()
    data class Error(val message: String) : NewsState()
}

class NewsViewModel : ViewModel() {
    private val repository = NewsRepository(NewsApi())
    
    private val _state = MutableStateFlow<NewsState>(NewsState.Loading)
    val state: StateFlow<NewsState> = _state.asStateFlow()

    init {
        loadNews()
    }

    fun loadNews() {
        viewModelScope.launch {
            _state.value = NewsState.Loading
            try {
                val articles = repository.getNews()
                _state.value = NewsState.Success(articles)
            } catch (e: Exception) {
                _state.value = NewsState.Error(e.message ?: "Unknown Error")
            }
        }
    }
}
