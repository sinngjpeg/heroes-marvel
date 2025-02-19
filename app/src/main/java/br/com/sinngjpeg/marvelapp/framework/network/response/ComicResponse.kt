package br.com.sinngjpeg.marvelapp.framework.network.response

import br.com.jpegsinng.core.domain.model.Comic
import com.google.gson.annotations.SerializedName

data class ComicResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailResponse
)

fun ComicResponse.toComicModel(): Comic {
    return Comic(
        id = this.id,
        imageUrl = this.thumbnail.getHttpsUrl()
    )
}