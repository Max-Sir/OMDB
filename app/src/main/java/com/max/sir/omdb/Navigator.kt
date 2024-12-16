package com.max.sir.omdb

import android.os.Bundle

interface Navigator {
    fun navigateTo(destination: Int, args: Bundle? = null)
}
