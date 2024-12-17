package com.max.sir.omdb.core

import androidx.annotation.StringRes

interface ManagerResource {
    fun getString(@StringRes id: Int) : String
}