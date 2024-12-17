package com.max.sir.omdb.core

import android.widget.ImageView
import com.bumptech.glide.Glide
import javax.inject.Inject

class ImageLoaderImpl @Inject constructor() : ImageLoader {

    override fun loadImage(url: String, imageView: ImageView) {
       Glide.with(imageView.context)
           .load(url)
           .into(imageView)
    }
}