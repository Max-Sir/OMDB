package com.max.sir.omdb.search.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.max.sir.omdb.search.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchSharedViewModel @Inject constructor(
) : ViewModel() {

    private val _movieId = MutableLiveData<String>()
    val movie: LiveData<String> = _movieId

    fun select(id: String) {
        _movieId.value = id
    }
}