package br.com.jpegsinng.testing.model

import br.com.jpegsinng.core.domain.model.Character

class CharacterFactory {
    fun create(hero: Hero) =
        when (hero) {
            Hero.ThreeDMan ->
                Character(
                    "3-D Man",
                    "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg",
                )

            Hero.ABomb ->
                Character(
                    "A-Bomb (HAS)",
                    "https://i.annihil.us/u/prod/marvel/i/mg/9/60/537bcaef0f6cf.jpg",
                )
        }

    sealed class Hero {
        object ThreeDMan : Hero()

        object ABomb : Hero()
    }
}
