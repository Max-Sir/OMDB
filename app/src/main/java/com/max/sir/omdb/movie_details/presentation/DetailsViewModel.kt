package com.max.sir.omdb.movie_details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.max.sir.omdb.movie_details.domain.MovieDetailsResponseState
import com.max.sir.omdb.movie_details.domain.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getMovieDetails: GetMovieDetailsUseCase,
) : ViewModel() {

    private val _data = MutableLiveData<MovieDetailsItemUi>()
    val data: LiveData<MovieDetailsItemUi> = _data

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = Channel<String>()
    val error = _error.receiveAsFlow()

    fun loadMovieDetails(id: String) = viewModelScope.launch {
        _isLoading.postValue(true)
        val result = getMovieDetails(id)
        if(result is MovieDetailsResponseState.Success) _data.postValue(result.data)
        else if(result is MovieDetailsResponseState.Failure) _error.send(result.message)
        _isLoading.postValue(false)
    }

    fun toggleFavorite(){
        // TODO implement
    }

}