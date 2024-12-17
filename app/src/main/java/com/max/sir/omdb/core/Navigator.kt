package com.max.sir.omdb.core

import android.os.Bundle

interface Navigator {
    fun navigateTo(destination: Int, args: Bundle? = null)
}
