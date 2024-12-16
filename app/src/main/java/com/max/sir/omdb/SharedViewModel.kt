package com.max.sir.omdb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val api: MovieApiService,
) : ViewModel() {
    val selectedMovie: LiveData<MovieDetailsResponse> get() = _selectedMovie
    private val _selectedMovie = MutableLiveData<MovieDetailsResponse>()

    fun loadDetails(id:String){
        viewModelScope.launch {
            _selectedMovie.postValue(api.getDetails(id).body())
        }
    }
}
