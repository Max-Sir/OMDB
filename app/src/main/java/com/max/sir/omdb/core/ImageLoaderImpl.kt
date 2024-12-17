package com.max.sir.omdb.core

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.max.sir.omdb.R
import javax.inject.Inject

class ImageLoaderImpl @Inject constructor() : ImageLoader {

    override fun loadImage(url: String, imageView: ImageView) {
       Glide.with(imageView.context)
           .load(url)
           .placeholder(R.drawable.ic_launcher_background)
           .error(R.drawable.ic_launcher_foreground)
           .diskCacheStrategy(DiskCacheStrategy.ALL)
           .into(imageView)
    }
}