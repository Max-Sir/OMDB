package com.max.sir.omdb.core

import android.os.Bundle
import androidx.navigation.NavController

class AppNavigator(private val navController: NavController) : Navigator {
    override fun navigateTo(destination: Int, args: Bundle?) {
        navController.navigate(destination, args)
    }
}
