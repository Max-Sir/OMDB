package com.max.sir.omdb

import androidx.navigation.NavController
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorProvider @Inject constructor() {
    private var navController: NavController? = null

    fun setNavController(controller: NavController) {
        navController = controller
    }

    fun provideNavigator(): Navigator {
        return AppNavigator(navController ?: throw IllegalStateException("NavController not set"))
    }
}

