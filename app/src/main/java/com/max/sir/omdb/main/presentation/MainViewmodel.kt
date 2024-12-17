package com.max.sir.omdb.main.presentation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.max.sir.omdb.core.NavigatorProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewmodel @Inject constructor(
    private val navigatorProvider: NavigatorProvider
)  : ViewModel() {

    fun setNavController(navController: NavController){
        navigatorProvider.setNavController(navController)
        
    }
}