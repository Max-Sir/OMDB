package com.max.sir.omdb.core

import android.content.Context
import javax.inject.Inject

class ManagerResourceImpl @Inject constructor(
   private val context: Context
): ManagerResource {
    override fun getString(id: Int): String = context.getString(id)
}