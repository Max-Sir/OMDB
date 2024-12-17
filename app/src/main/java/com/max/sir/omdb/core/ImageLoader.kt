package com.max.sir.omdb.core

import android.widget.ImageView

interface ImageLoader {

    fun loadImage(url: String, imageView: ImageView)

}