package br.com.sinngjpeg.marvelapp.framework.network.response

import br.com.jpegsinng.core.domain.model.Character
import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailResponse
)

fun CharacterResponse.toCharacterModel(): Character {
    return Character(
        id = this.id,
        name = this.name,
        description,
        imageUrl = this.thumbnail.getHttpsUrl()
    )
}
