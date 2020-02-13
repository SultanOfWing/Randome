package com.seleznov.randome.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
import com.bumptech.glide.request.RequestOptions
import com.seleznov.randome.RandomApp

class Extensions {

    val app: RandomApp
        get() = RandomApp.app

    fun <T> ImageView.loadImage(
        source: T,
        format: DecodeFormat = DecodeFormat.PREFER_RGB_565
    ) {
        Glide.with(app)
            .load(source)
            .apply(provideRequestOptions(format))
            .into(this)
    }

    private fun provideRequestOptions(format: DecodeFormat): RequestOptions {
        return RequestOptions()
            .downsample(DownsampleStrategy.AT_MOST)
            .dontAnimate()
            .format(format)
    }

}