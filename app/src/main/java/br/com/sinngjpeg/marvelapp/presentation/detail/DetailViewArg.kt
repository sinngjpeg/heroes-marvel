package br.com.sinngjpeg.marvelapp.presentation.detail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailViewArg(
    val characterId: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
) : Parcelable
