package br.com.sinngjpeg.marvelapp.framework.imageloader

import android.widget.ImageView
import br.com.sinngjpeg.marvelapp.R
import com.bumptech.glide.Glide
import javax.inject.Inject

class GlideImageLoader @Inject constructor() : ImageLoader {
        override fun load(imageView: ImageView, imageUrl: String, placeholder: Int, fallback: Int, ) {
            Glide
                .with(imageView.rootView)
                .load(imageUrl)
                .placeholder(placeholder)
                .fallback(R.drawable.ic_image_error)
                .into(imageView)
        }
    }
