package com.max.sir.omdb.search.presentation

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.max.sir.omdb.search.data.MovieRepository
import com.max.sir.omdb.R
import com.max.sir.omdb.core.NavigatorProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: MovieRepository,
    private val navPort: NavigatorProvider,
) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    fun searchMovies(query: String) {
        viewModelScope.launch {
            _movies.value = repository.searchMovies(query)
            Log.i("mov", "$query, ${movies.value}")
        }
    }

    fun toggleFavorite(movie: Movie) {
        viewModelScope.launch {
            repository.toggleFavorite(movie)
        }
    }

    fun openDetails() {
        navPort.provideNavigator().navigateTo(R.id.detailsFragment)
    }

}
