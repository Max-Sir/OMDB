package com.max.sir.omdb.core

import androidx.navigation.NavController
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorProvider @Inject constructor() {
    private var navController: NavController? = null
    private var navigator: Navigator? = null

    fun setNavController(controller: NavController) {
        navController = controller
    }

    fun provideNavigator(): Navigator {
        return if(navigator!=null) navigator!!
        else AppNavigator(navController ?: throw IllegalStateException("NavController not set"))
            .also {
                navigator = it
            }
    }
}

