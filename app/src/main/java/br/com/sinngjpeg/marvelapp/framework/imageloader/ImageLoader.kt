package br.com.sinngjpeg.marvelapp.framework.imageloader

import android.widget.ImageView
import androidx.annotation.DrawableRes
import br.com.sinngjpeg.marvelapp.R

interface ImageLoader {

    fun load(
        imageView: ImageView,
        imageUrl: String,
        //TODO MUDAR PLACEHOLDER
        @DrawableRes placeholder: Int = R.drawable.ic_image_error,
        @DrawableRes fallback: Int = R.drawable.ic_image_error
    )
}