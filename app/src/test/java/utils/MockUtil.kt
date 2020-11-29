package utils

import com.example.superheroes.model.SuperHero

object MockUtil {

    fun mockHero() = SuperHero(
        30,
        "Ant-Man",
        "https://jslowinski.github.io/SuperHeroList/Images/Ant-Man.png"
    )

    fun mockHeroList() = listOf(mockHero())
}