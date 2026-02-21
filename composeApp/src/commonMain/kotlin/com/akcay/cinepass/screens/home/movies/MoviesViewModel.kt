package com.akcay.cinepass.screens.home.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akcay.cinepass.core.ext.execute
import com.akcay.cinepass.core.onFailure
import com.akcay.cinepass.core.onSuccess
import com.akcay.cinepass.domain.movies.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val repository: MovieRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MoviesUIState())
    val uiState: StateFlow<MoviesUIState> = _uiState

    fun load() {
        viewModelScope.launch {
            execute { repository.fetchMovies() }.onSuccess { movies ->
                _uiState.update {
                    it.copy(
                        items = movies
                    )
                }
            }.onFailure {

            }
        }
    }
}

