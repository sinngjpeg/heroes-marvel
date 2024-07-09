package br.com.jpegsinng.core.domain.model

import br.com.jpegsinng.core.domain.model.Character

data class CharacterPaging(
    val offset: Int,
    val total: Int,
    val characters: List<Character>
)