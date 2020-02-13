package com.seleznov.randome.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(
    source: String,
    context: Context,
    format: DecodeFormat = DecodeFormat.PREFER_RGB_565
) {
    Glide.with(context)
        .load(source)
        .apply(provideRequestOptions(format))
        .into(this)
}

fun String.concat(text: String): String {
    return "$this $text"

}

private fun provideRequestOptions(format: DecodeFormat): RequestOptions {
    return RequestOptions()
        .downsample(DownsampleStrategy.AT_MOST)
        .dontAnimate()
        .format(format)
}
