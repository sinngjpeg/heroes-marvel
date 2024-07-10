package br.com.jpegsinng.testing.model

import br.com.jpegsinng.core.domain.model.Character

class CharacterFactory {
    fun create(hero: Hero) = when (hero) {
        Hero.ThreeDMan -> Character(
            1011334,
            "3-D Man",
            "",
            "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg"
                .replace("http", "https")
        )

        Hero.Abomb -> Character(
            1017100,
            "A-Bomb (HAS)",
            "Rick Jones has been Hulk's best bud since day one, but now he's more than a friend..he's a teammate! Transformed by a Gamma energy explosion, A-Bomb's, tchick, armored skin is just as strong and powerful as its is blue. And when he curls into action, he uses it like a giant bowling ball of destruction!",
            "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg"
                .replace("http", "https")
        )
    }

    sealed class Hero {
        object ThreeDMan : Hero()
        object Abomb : Hero()
    }
}
