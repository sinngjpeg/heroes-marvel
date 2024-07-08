package br.com.sinngjpeg.marvelapp.framework.network.response

import br.com.jpegsinng.core.domain.model.Character

data class CharacterResponse(
    val id: String,
    val name: String,
    val thumbnail: ThumbnailResponse,
)

fun CharacterResponse.toCharacter() : Character {
    return Character(
        name = this.name,
        thumbnail = "${this.thumbnail.path}.${this.thumbnail.extension}".replace("http", "https")
    )
}
